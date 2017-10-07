package com.SHGroup.ParticlePlus.Lib;

import org.bukkit.Location;
import org.bukkit.util.Vector;

public class ConeEffect extends Effect {

    /**
     * ParticleType of spawned particle
     */
    public ParticleEffect particle = ParticleEffect.FLAME;


    public float lengthGrow = .05f;


    public double angularVelocity = Math.PI / 16;


    public int particles = 10;


    public float radiusGrow = 0.006f;


    public int particlesCone = 180;


    public double rotation = 0;


    public boolean randomize = false;


    protected int step = 0;

    public ConeEffect(EffectManager effectManager) {
        super(effectManager);
        type = EffectType.REPEATING;
        period = 1;
        iterations = 200;
    }

    @Override
    public void onRun() {
        Location location = getLocation();
        for (int x = 0; x < particles; x++) {
            if (step > particlesCone)
                step = 0;
            if (randomize && step == 0)
                rotation = RandomUtils.getRandomAngle();
            double angle = step * angularVelocity + rotation;
            float radius = step * radiusGrow;
            float length = step * lengthGrow;
            Vector v = new Vector(Math.cos(angle) * radius, length, Math.sin(angle) * radius);
            VectorUtils.rotateAroundAxisX(v, (location.getPitch() + 90) * MathUtils.degreesToRadians);
            VectorUtils.rotateAroundAxisY(v, -location.getYaw() * MathUtils.degreesToRadians);

            location.add(v);
            display(particle, location);
            location.subtract(v);
            step++;
        }
    }
}
