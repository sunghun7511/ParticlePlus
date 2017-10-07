package com.SHGroup.ParticlePlus.Lib;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.util.Vector;

public class CylinderEffect extends Effect {

    /**
     * Particle of the cube
     */
    public ParticleEffect particle = ParticleEffect.FLAME;


    public float radius = 1;


    public float height = 3;


    public double angularVelocityX = Math.PI / 200;


    public double angularVelocityY = Math.PI / 170;


    public double angularVelocityZ = Math.PI / 155;


    public double rotationX, rotationY, rotationZ;


    public int particles = 100;


    public boolean enableRotation = true;


    public boolean solid = false;


    protected int step = 0;


    protected float sideRatio = 0;

    public CylinderEffect(EffectManager effectManager) {
        super(effectManager);
        type = EffectType.REPEATING;
        period = 2;
        iterations = 200;
    }

    @SuppressWarnings("deprecation")
	@Override
    public void onRun() {
        Location location = getLocation();
        if (sideRatio == 0) calculateSideRatio();
        Random r = RandomUtils.random;
        double xRotation = rotationX, yRotation = rotationY, zRotation = rotationZ;
        if (enableRotation) {
            xRotation += step * angularVelocityX;
            yRotation += step * angularVelocityY;
            zRotation += step * angularVelocityZ;
        }
        for (int i = 0; i < particles; i++) {
            float multi = (solid) ? r.nextFloat() : 1;
            Vector v = RandomUtils.getRandomCircleVector().multiply(radius);
            if (r.nextFloat() <= sideRatio) {
                v.multiply(multi);
                v.setY((r.nextFloat() * 2 - 1) * (height / 2));
            } else {
                v.multiply(r.nextFloat());
                if (r.nextFloat() < 0.5) {
                    v.setY(multi * (height / 2));
                } else {
                    v.setY(-multi * (height / 2));
                }
            }
            if (enableRotation)
                VectorUtils.rotateVector(v, xRotation, yRotation, zRotation);
            particle.display(location.add(v), visibleRange);
            location.subtract(v);
        }
        display(particle, location);
        step++;
    }

    protected void calculateSideRatio() {
        float grounds, side;
        grounds = MathUtils.PI * MathUtils.PI * radius * 2;
        side = 2 * MathUtils.PI * radius * height;
        sideRatio = side / (side + grounds);
    }
}
