package com.SHGroup.ParticlePlus.Lib;

import org.bukkit.Location;
import org.bukkit.util.Vector;

public class ShieldEffect extends Effect {
    /**
     * ParticleType of spawned particle
     */
    public ParticleEffect particle = ParticleEffect.FLAME;


    public int radius = 3;


    public int particles = 50;


    public boolean sphere = false;

    public ShieldEffect(EffectManager effectManager) {
        super(effectManager);
        type = EffectType.REPEATING;
        iterations = 500;
        period = 1;
    }

    @Override
    public void onRun() {
        Location location = getLocation();
        for (int i = 0; i < particles; i++) {
            Vector vector = RandomUtils.getRandomVector().multiply(radius);
            if (!sphere)
                vector.setY(Math.abs(vector.getY()));
            location.add(vector);
            display(particle, location);
            location.subtract(vector);
        }
    }

}
