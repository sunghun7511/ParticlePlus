package com.SHGroup.ParticlePlus.Lib;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class CloudEffect extends Effect{
	
	/*
	 * Particle of the cloud
	 */
	public ParticleEffect cloudParticle = ParticleEffect.CLOUD;
	public Color cloudColor = null;
	

	public ParticleEffect mainParticle = ParticleEffect.DRIP_WATER;


	public float cloudSize = .7f;
	

	public float particleRadius = cloudSize-.1f;
	

	public double yOffset = .8;
	
	public CloudEffect(EffectManager manager){
		super(manager);
		type = EffectType.REPEATING;
		period = 5;
		iterations = 50;
	}
	
	@Override
	public void onRun(){
		Location location = getLocation();
		location.add(0, yOffset, 0);
		for(int i = 0; i < 50; i++){
			Vector v = RandomUtils.getRandomCircleVector().multiply(RandomUtils.random.nextDouble() * cloudSize);
			display(cloudParticle, location.add(v), cloudColor, 0, 7);
			location.subtract(v);
		}
		Location l = location.add(0, .2, 0);
		for(int i = 0; i < 15; i++){
			int r = RandomUtils.random.nextInt(2);
			double x = RandomUtils.random.nextDouble() * particleRadius;
			double z = RandomUtils.random.nextDouble() * particleRadius;
			l.add(x, 0, z);
			if(r!=1)
				display(mainParticle, l);
			l.subtract(x, 0, z);
			l.subtract(x, 0, z);
			if(r!=1)
				display(mainParticle, l);
			l.add(x, 0, z);
		}
	}

}
