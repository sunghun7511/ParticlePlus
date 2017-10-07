package com.SHGroup.ParticlePlus.Lib;

import org.bukkit.Location;
import org.bukkit.util.Vector;

/**
 * Creates a 2D Heart in 3D space. Thanks to the author for sharing it!
 * @author <a href="http://forums.bukkit.org/members/qukie.90952701/">Qukie</a>
 */
public class HeartEffect extends Effect {



    public ParticleEffect particle = ParticleEffect.CRIT_MAGIC;



    public int particles = 50;



    public double xRotation, yRotation, zRotation = 0;



    public double yFactor = 1, xFactor = 1;



    public double factorInnerSpike = 0.8;



    public double compressYFactorTotal = 2;



    public float compilaction = 2F;


    public HeartEffect(EffectManager effectManager) {
        super(effectManager);
    }

    @Override
    public void onRun() {
        Location location = getLocation();
        Vector vector = new Vector();
        for (int i = 0; i < particles; i++) {
            float alpha = ((MathUtils.PI / compilaction) / particles) * i;
            double phi = Math.pow(Math.abs(MathUtils.sin(2 * compilaction * alpha)) + factorInnerSpike * Math.abs(MathUtils.sin(compilaction * alpha)), 1 / compressYFactorTotal);

            vector.setY(phi * (MathUtils.sin(alpha) + MathUtils.cos(alpha)) * yFactor);
            vector.setZ(phi * (MathUtils.cos(alpha) - MathUtils.sin(alpha)) * xFactor);

            VectorUtils.rotateVector(vector, xRotation, yRotation, zRotation);

            display(particle, location.add(vector));
            location.subtract(vector);
        }
    }


}