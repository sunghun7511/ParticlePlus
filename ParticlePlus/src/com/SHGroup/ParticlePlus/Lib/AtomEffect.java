package com.SHGroup.ParticlePlus.Lib;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class AtomEffect extends Effect {

    /**
     * ParticleType of the nucleus
     */
    public ParticleEffect particleNucleus = ParticleEffect.DRIP_WATER;
    public Color colorNucleus = null;


    public ParticleEffect particleOrbital = ParticleEffect.DRIP_LAVA;
    public Color colorOrbital = null;


    public int radius = 3;


    public float radiusNucleus = .2f;


    public int particlesNucleus = 10;


    public int particlesOrbital = 10;


    public int orbitals = 3;


    public double rotation = 0;


    public double angularVelocity = Math.PI / 80d;


    protected int step = 0;

    public AtomEffect(EffectManager effectManager) {
        super(effectManager);
        type = EffectType.REPEATING;
        period = 2;
        iterations = 200;
    }

    @Override
    public void onRun() {
        Location location = getLocation();
        for (int i = 0; i < particlesNucleus; i++) {
            Vector v = RandomUtils.getRandomVector().multiply(radius * radiusNucleus);
            location.add(v);
            display(particleNucleus, location, colorNucleus);
            location.subtract(v);
        }
        for (int i = 0; i < particlesOrbital; i++) {
            double angle = step * angularVelocity;
            for (int j = 0; j < orbitals; j++) {
                double xRotation = (Math.PI / orbitals) * j;
                Vector v = new Vector(Math.cos(angle), Math.sin(angle), 0).multiply(radius);
                VectorUtils.rotateAroundAxisX(v, xRotation);
                VectorUtils.rotateAroundAxisY(v, rotation);
                location.add(v);
                display(particleOrbital, location, colorOrbital);
                location.subtract(v);
            }
            step++;
        }
    }

}
