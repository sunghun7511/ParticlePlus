package com.SHGroup.ParticlePlus.Lib;

import org.bukkit.Location;
import org.bukkit.util.Vector;

public class AnimatedBallEffect extends Effect {


    public ParticleEffect particle = ParticleEffect.SPELL_WITCH;


    public int particles = 150;


    public int particlesPerIteration = 10;


    public float size = 1F;


    public float xFactor = 1F, yFactor = 2F, zFactor = 1F;


    public float xOffset, yOffset = 0.8F, zOffset;


    public double xRotation, yRotation, zRotation = 0;


    protected int step;

    public AnimatedBallEffect(EffectManager effectManager) {
        super(effectManager);
        this.type = EffectType.REPEATING;
        this.iterations = 500;
        this.period = 1;
    }

    @Override
    public void onRun() {
        Vector vector = new Vector();
        Location location = getLocation();
        for (int i = 0; i < particlesPerIteration; i++) {
            step++;

            float t = (MathUtils.PI / particles) * step;
            float r = MathUtils.sin(t) * size;
            float s = 2 * MathUtils.PI * t;

            vector.setX(xFactor * r * MathUtils.cos(s) + xOffset);
            vector.setZ(zFactor * r * MathUtils.sin(s) + zOffset);
            vector.setY(yFactor * size * MathUtils.cos(t) + yOffset);

            VectorUtils.rotateVector(vector, xRotation, yRotation, zRotation);

            display(particle, location.add(vector));
            location.subtract(vector);
        }
    }

}
