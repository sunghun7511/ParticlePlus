package com.SHGroup.ParticlePlus.Lib;

import org.bukkit.Location;
import org.bukkit.util.Vector;

public class CircleEffect extends Effect{
	

    /*
     * ParticleType of spawned particle
     */
    public ParticleEffect particle = ParticleEffect.VILLAGER_HAPPY;


    public double xRotation, yRotation, zRotation = 0;
    

    public double angularVelocityX = Math.PI / 200;


    public double angularVelocityY = Math.PI / 170;


    public double angularVelocityZ = Math.PI / 155;


    public float radius = .4f;


    protected float step = 0;
   

    public double xSubtract, ySubtract, zSubtract;
    

    public boolean enableRotation = true;
    

    public int particles = 20;

    public CircleEffect(EffectManager effectManager) {
        super(effectManager);
        type = EffectType.REPEATING;
        period = 2;
        iterations = 50;
    }
    
    @Override
    public void onRun(){
    	Location location = getLocation();
    	location.subtract(xSubtract, ySubtract, zSubtract);
    	double inc = (2*Math.PI)/particles;
    	double angle = step * inc;
		Vector v = new Vector();
		v.setX(Math.cos(angle) * radius);
    	v.setZ(Math.sin(angle) * radius);
    	VectorUtils.rotateVector(v, xRotation, yRotation, zRotation);
		if(enableRotation)
			VectorUtils.rotateVector(v, angularVelocityX * step, angularVelocityY * step, angularVelocityZ * step);
		display(particle, location.add(v), 0, 30);
		step++;
    }

}
