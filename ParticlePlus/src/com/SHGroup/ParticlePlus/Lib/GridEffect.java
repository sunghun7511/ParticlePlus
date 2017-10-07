package com.SHGroup.ParticlePlus.Lib;

import org.bukkit.Location;
import org.bukkit.util.Vector;

public class GridEffect extends Effect {

    /**
     * ParticleType of the nucleus
     */
    public ParticleEffect particle = ParticleEffect.FLAME;


    public int rows = 5;


    public int columns = 10;


    public float widthCell = 1;


    public float heightCell = 1;


    public int particlesWidth = 4;


    public int particlesHeight = 3;


    public double rotation = 0;

    public GridEffect(EffectManager effectManager) {
        super(effectManager);
        type = EffectType.INSTANT;
        period = 5;
        iterations = 50;
    }

    @Override
    public void onRun() {
        Location location = getLocation();
        Vector v = new Vector();
        for (int i = 0; i <= (rows + 1); i++) {
            for (int j = 0; j < particlesWidth * (columns + 1); j++) {
                v.setY(i * heightCell);
                v.setX(j * widthCell / particlesWidth);
                addParticle(location, v);
            }
        }
        for (int i = 0; i <= (columns + 1); i++) {
            for (int j = 0; j < particlesHeight * (rows + 1); j++) {
                v.setX(i * widthCell);
                v.setY(j * heightCell / particlesHeight);
                addParticle(location, v);
            }
        }
    }

    protected void addParticle(Location location, Vector v) {
        v.setZ(0);
        VectorUtils.rotateAroundAxisY(v, rotation);
        location.add(v);
        display(particle, location);
        location.subtract(v);
    }

}
