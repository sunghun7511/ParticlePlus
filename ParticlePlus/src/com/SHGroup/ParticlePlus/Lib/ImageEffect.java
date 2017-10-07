package com.SHGroup.ParticlePlus.Lib;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.bukkit.Location;
import org.bukkit.util.Vector;

public class ImageEffect extends Effect {

    /**
     * Particle to draw the image
     */
    public ParticleEffect particle = ParticleEffect.FLAME;


    public String fileName = null;


    public boolean invert = false;


    public int stepX = 10;


    public int stepY = 10;


    public float size = (float) 1 / 40;


    public boolean enableRotation = true;


    public Plane plane = Plane.XYZ;


    public double angularVelocityX = Math.PI / 200;


    public double angularVelocityY = Math.PI / 170;


    public double angularVelocityZ = Math.PI / 155;


    protected BufferedImage image = null;


    protected boolean isGif = false;


    protected File gifFile = null;


    protected int step = 0;

    public ImageEffect(EffectManager effectManager) throws IOException {
        super(effectManager);
        type = EffectType.REPEATING;
        period = 10;
        iterations = 60;
    }

    public void loadFile(File file) {
        try {
            image = ImageIO.read(file);
            this.isGif = file.getName().endsWith(".gif");
            this.gifFile = file;
        } catch (Exception ex) {
            ex.printStackTrace();
            image = null;
        }
    }

    @Override
    public void onRun() {
        if (image == null && fileName != null) {
            loadFile(new File(fileName));
        }
        if (image == null) {
            cancel();
            return;
        }
        if(isGif){
            try {
                image = getImg(step);
            } catch (IOException e) {
                e.printStackTrace();
            }
            step++;
        }
        Location location = getLocation();
        int clr;
        for (int y = 0; y < image.getHeight(); y += stepY) {
            for (int x = 0; x < image.getWidth(); x += stepX) {
                clr = image.getRGB(x, y);
                if (!invert && Color.black.getRGB() != clr)
                    continue;
                else if (invert && Color.black.getRGB() == clr)
                    continue;
                Vector v = new Vector((float) image.getWidth() / 2 - x, (float) image.getHeight() / 2 - y, 0).multiply(size);
                VectorUtils.rotateAroundAxisY(v, -location.getYaw() * MathUtils.degreesToRadians);
                display(particle, location.add(v));
                location.subtract(v);
            }
        }
    }

    private BufferedImage getImg(int s) throws IOException{
        ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
        ImageReader reader = ImageIO.getImageReadersBySuffix("GIF").next();
        ImageInputStream in = ImageIO.createImageInputStream(gifFile);
        reader.setInput(in);
        for (int i = 0, count = reader.getNumImages(true); i < count; i++){
            BufferedImage image = reader.read(i);
            images.add(image);
        }
        if(step>=reader.getNumImages(true)) {
            step = 0;
            return images.get(s-1);
        }
        return images.get(s);
    }

    public enum Plane{
        X, Y, Z, XY, XZ, XYZ, YZ;
    }

}
