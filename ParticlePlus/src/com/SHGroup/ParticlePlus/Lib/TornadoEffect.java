package com.SHGroup.ParticlePlus.Lib;

import java.util.ArrayList;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class TornadoEffect extends Effect{
	
	/*
	 * Tornado particle
	 */
	public ParticleEffect tornadoParticle = ParticleEffect.FLAME;
	public Color tornadoColor = null;
	

	public ParticleEffect cloudParticle = ParticleEffect.CLOUD;
	public Color cloudColor = null;
	

	public float cloudSize = 2.5f;
	

	public double yOffset = .8;
	

	public float tornadoHeight = 5f;
	

	public float maxTornadoRadius = 5f;
	

	public boolean showCloud = true;
	

	public boolean showTornado = true;
    

    public double distance = .375d;
    

    protected int step = 0;
	
	public TornadoEffect(EffectManager manager){
		super(manager);
		type = EffectType.REPEATING;
		period = 5;
		iterations = 20;
	}
	
	@Override
	public void onRun(){
		Location l = getLocation().add(0, yOffset, 0);
		for(int i = 0; i < (100 * cloudSize); i++){
			Vector v = RandomUtils.getRandomCircleVector().multiply(RandomUtils.random.nextDouble() * cloudSize);
			if(showCloud){
				display(cloudParticle, l.add(v), cloudColor, 0, 7);
				l.subtract(v);
			}
		}
		Location t = l.clone().add(0, .2, 0);
		double r = .45 * (maxTornadoRadius*(2.35/tornadoHeight));
		for(double y = 0; y < tornadoHeight; y+=distance){
			double fr = r * y;
			if(fr > maxTornadoRadius)
				fr = maxTornadoRadius;
			for(Vector v : createCircle(y, fr)){
				if(showTornado){
					display(tornadoParticle, t.add(v), tornadoColor);
					t.subtract(v);
					step++;
				}
			}
		}
		l.subtract(0, yOffset, 0);
	}
	
	public ArrayList<Vector> createCircle(double y, double radius){
		double amount = radius * 64;
		double inc = (2*Math.PI)/amount;
		ArrayList<Vector> vecs = new ArrayList<Vector>();
		for(int i = 0; i < amount; i++){
			double angle = i * inc;
			double x = radius * Math.cos(angle);
			double z = radius * Math.sin(angle);
			Vector v = new Vector(x, y, z);
			vecs.add(v);
		}
		return vecs;
	}

}
