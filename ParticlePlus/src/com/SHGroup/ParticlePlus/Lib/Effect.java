package com.SHGroup.ParticlePlus.Lib;

import java.lang.ref.WeakReference;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;

public abstract class Effect implements Runnable {

	/**
	 * Handles the type, the effect is played.
	 * 
	 * @see {@link com.SHGroup.ParticlePlus.Lib.EffectType}
	 */
	public EffectType type = EffectType.INSTANT;


    public Color color = null;


    public float speed = 1;


	public int delay = 0;


	public int period = 1;


	public int iterations = 0;


	public Runnable callback = null;


	public float visibleRange = 32;


    public boolean autoOrient = true;


    public Vector offset = null;


    public Vector targetOffset = null;


    public boolean asynchronous = true;

    private Location location = null;
    private WeakReference<Entity> entity = new WeakReference<Entity>(null);
    private Location target = null;
    private WeakReference<Entity> targetEntity = new WeakReference<Entity>(null);

    private Vector locationEntityOffset = null;
    private Vector targetEntityOffset = null;

	private boolean done = false;
	protected final EffectManager effectManager;
    protected Runnable asyncRunnableTask;

	public Effect(EffectManager effectManager) {
        if (effectManager == null) {
            throw new IllegalArgumentException("EffectManager cannot be null!");
        }
		this.effectManager = effectManager;
	}

    public final void cancel() {
        cancel(true);
    }

	public final void cancel(boolean callback) {
		if (callback)
			done();
		else
			done = true;
	}

	private void done() {
		done = true;
		effectManager.done(this);
        onDone();
	}

	public final boolean isDone() {
		return done;
	}

	public abstract void onRun();


        public void onDone() {}

	@Override
	public final void run() {
        if (!validate()) {
            cancel();
            return;
        }
		if (done)
			return;
        if (asynchronous)
        {
            if (asyncRunnableTask == null)
            {
                final Effect effect = this;
                asyncRunnableTask = new Runnable() {
                    @Override
                    public void run()
                    {
                        try {
                            effect.onRun();
                        } catch (Exception ex) {
                            effectManager.onError(ex);
                            Bukkit.getScheduler().runTask(effectManager.getOwningPlugin(), new Runnable() {
                               @Override
                               public void run()
                               {
                                   effect.done();
                               }
                            });
                        }
                    }
                };
            }
            Bukkit.getScheduler().runTaskAsynchronously(effectManager.getOwningPlugin(), asyncRunnableTask);
        }
        else
        {
            try {
                onRun();
            } catch (Exception ex) {
                done();
                effectManager.onError(ex);
            }
        }
		if (type == EffectType.REPEATING) {
			if (iterations == -1)
				return;
			iterations--;
			if (iterations < 1)
				done();
		} else {
			done();
		}
	}

    protected final boolean validate() {
        updateLocation();
        updateTarget();
        if (location == null) return false;
        if (autoOrient) {
            if (target != null) {
                Vector direction = target.toVector().subtract(location.toVector());
                location.add(direction);
                target.add(direction.multiply(-1));
            }
        }

        return true;
    }

	public final void start() {
		effectManager.start(this);
	}

	public final void infinite() {
		type = EffectType.REPEATING;
		iterations = -1;
	}


    public Entity getEntity()
    {
        return this.entity.get();
    }


    public Entity getTargetEntity()
    {
        return this.targetEntity.get();
    }

    protected void updateLocation()
    {
        Entity entityReference = entity.get();
        if (entityReference != null) {
            Location currentLocation = null;
            if (entityReference instanceof LivingEntity) {
                currentLocation = ((LivingEntity)entityReference).getEyeLocation();
            } else {
                currentLocation = entityReference.getLocation();
            }
            if (locationEntityOffset != null) {
                currentLocation.add(locationEntityOffset);
            } else if (location != null) {
                locationEntityOffset = location.toVector().subtract(currentLocation.toVector());
                currentLocation = location;
            }

            setLocation(currentLocation);
        }
    }


    public final Location getLocation()
    {
        return location;
    }

    protected void updateTarget()
    {
        Entity entityReference = targetEntity.get();
        if (entityReference != null) {
            Location currentLocation = null;
            if (entityReference instanceof LivingEntity) {
                currentLocation = ((LivingEntity)entityReference).getEyeLocation();
            } else {
                currentLocation = entityReference.getLocation();
            }
            if (targetEntityOffset != null) {
                currentLocation.add(targetEntityOffset);
            } else if (target != null) {
                targetEntityOffset = target.toVector().subtract(currentLocation.toVector());
                currentLocation = target;
            }

            setTarget(currentLocation);
        }
    }


    public final Location getTarget()
    {
        return target;
    }


    public void setEntity(Entity entity) {
        this.entity = new WeakReference<Entity>(entity);
    }


    public void setTargetEntity(Entity entity) {
        this.targetEntity = new WeakReference<Entity>(entity);
    }


    public void setLocation(Location location) {
        if (location == null) {
            throw new IllegalArgumentException("Location cannot be null!");
        }
        this.location = location == null ? null : location.clone();
        if (offset != null && this.location != null) {
            this.location = this.location.add(offset);
        }
    }


    public void setTarget(Location location) {
        this.target = location == null ? null : location.clone();
        if (targetOffset != null && this.target != null) {
            this.target = this.target.add(targetOffset);
        }
    }

    public void display(ParticleEffect effect, Location location)
    {
        display(effect, location, this.color);
    }

    protected void display(ParticleEffect particle, Location location, Color color)
    {
        display(particle, location, color, 0, 1);
    }

    protected void display(ParticleEffect particle, Location location, float speed, int amount)
    {
        display(particle, location, this.color, speed, amount);
    }

    protected void display(ParticleEffect particle, Location location, Color color, float speed, int amount)
    {
        particle.display(null, location, color, visibleRange, 0, 0, 0, speed, amount);
    }
}

