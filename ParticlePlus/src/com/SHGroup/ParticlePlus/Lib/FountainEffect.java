package com.SHGroup.ParticlePlus.Lib;

import org.bukkit.Location;
import org.bukkit.util.Vector;

public class FountainEffect extends Effect {
    /**
     * Particle of the fountain
     */
    public ParticleEffect particle = ParticleEffect.WATER_SPLASH;


    public int strands = 10;


    public int particlesStrand = 150;


    public int particlesSpout = 200;


    public float radius = 5;


    public float radiusSpout = .1f;


    public float height = 3;


    public float heightSpout = 7;


    public double rotation = Math.PI / 4;

    public FountainEffect(EffectManager effectManager) {
        super(effectManager);
        type = EffectType.REPEATING;
        period = 2;
        iterations = 100;
    }

    @Override
    public void onRun() {
        Location location = getLocation();
        for (int i = 1; i <= strands; i++) {
            double angle = 2 * i * Math.PI / strands + rotation;
            for (int j = 1; j <= particlesStrand; j++) {
                float ratio = (float) j / particlesStrand;
                double x, y, z;
                x = Math.cos(angle) * radius * ratio;
                y = Math.sin(Math.PI * j / particlesStrand) * height;
                z = Math.sin(angle) * radius * ratio;
                location.add(x, y, z);
                display(particle, location);
                location.subtract(x, y, z);
            }
        }
        for (int i = 0; i < particlesSpout; i++) {
            Vector v = RandomUtils.getRandomCircleVector().multiply(RandomUtils.random.nextFloat() * radius * radiusSpout);
            v.setY(RandomUtils.random.nextFloat() * heightSpout);
            location.add(v);
            display(particle, location);
            location.subtract(v);
        }
    }

}
