package com.SHGroup.ParticlePlus.Lib;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;

public class TraceEffect extends Effect {

    /**
     * Particle to spawn
     */
    public ParticleEffect particle = ParticleEffect.FLAME;


    public int refresh = 5;


    public int maxWayPoints = 30;


    protected List<Vector> wayPoints;


    protected int step = 0;


    protected World world;

    public TraceEffect(EffectManager effectManager) {
        super(effectManager);
        type = EffectType.REPEATING;
        period = 1;
        iterations = 600;
        wayPoints = new ArrayList<Vector>();
    }

    @Override
    public void onRun() {
        Location location = getLocation();
        if (world == null) {
            world = location.getWorld();
        } else if (!location.getWorld().equals(world)) {
            cancel(true);
            return;
        }

        if (wayPoints.size() >= maxWayPoints)
            wayPoints.remove(0);

        wayPoints.add(location.toVector());
        step++;
        if (step % refresh != 0)
            return;

        for (Vector position : wayPoints) {
            Location particleLocation = new Location(world, position.getX(), position.getY(), position.getZ());
            display(particle, particleLocation);
        }
    }

}
