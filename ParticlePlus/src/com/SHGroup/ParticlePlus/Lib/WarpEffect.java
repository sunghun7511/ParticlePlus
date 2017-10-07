package com.SHGroup.ParticlePlus.Lib;

import org.bukkit.Location;

public class WarpEffect extends Effect {

    /**
     * Radius of the spawned circles
     */
    public float radius = 1;


    public int particles = 20;


    public ParticleEffect particle = ParticleEffect.FIREWORKS_SPARK;


    public float grow = .2f;


    public int rings = 12;


    protected int step = 0;

    public WarpEffect(EffectManager effectManager) {
        super(effectManager);
        type = EffectType.REPEATING;
        period = 2;
        iterations = rings;
    }

    @Override
    public void onRun() {
        Location location = getLocation();
        if (step > rings)
            step = 0;
        double x, y, z;
        y = step * grow;
        location.add(0, y, 0);
        for (int i = 0; i < particles; i++) {
            double angle = (double) 2 * Math.PI * i / particles;
            x = Math.cos(angle) * radius;
            z = Math.sin(angle) * radius;
            location.add(x, 0, z);
            display(particle, location);
            location.subtract(x, 0, z);
        }
        location.subtract(0, y, 0);
        step++;
    }

}
