package com.SHGroup.ParticlePlus.Lib;

import org.bukkit.Location;
import org.bukkit.util.Vector;

public class VortexEffect extends Effect {

    /**
     * ParticleType of spawned particle
     */
    public ParticleEffect particle = ParticleEffect.FLAME;


    public float radius = 2;


    public float grow = .05f;


    public double radials = Math.PI / 16;


    public int circles = 3;


    public int helixes = 4;


    protected int step = 0;

    public VortexEffect(EffectManager effectManager) {
        super(effectManager);
        type = EffectType.REPEATING;
        period = 1;
        iterations = 200;
    }

    @Override
    public void onRun() {
        Location location = getLocation();
        for (int x = 0; x < circles; x++) {
            for (int i = 0; i < helixes; i++) {
                double angle = step * radials + (2 * Math.PI * i / helixes);
                Vector v = new Vector(Math.cos(angle) * radius, step * grow, Math.sin(angle) * radius);
                VectorUtils.rotateAroundAxisX(v, (location.getPitch() + 90) * MathUtils.degreesToRadians);
                VectorUtils.rotateAroundAxisY(v, -location.getYaw() * MathUtils.degreesToRadians);

                location.add(v);
                display(particle, location);
                location.subtract(v);
            }
            step++;
        }
    }

}
