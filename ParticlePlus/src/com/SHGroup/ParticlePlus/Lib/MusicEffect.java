package com.SHGroup.ParticlePlus.Lib;

import org.bukkit.Location;

public class MusicEffect extends Effect {

    /**
     * Radials to spawn next note.
     */
    public double radialsPerStep = Math.PI / 8;


    public float radius = .4f;


    protected float step = 0;

    public MusicEffect(EffectManager effectManager) {
        super(effectManager);
        type = EffectType.REPEATING;
        iterations = 400;
        period = 1;
    }

    @SuppressWarnings("deprecation")
	@Override
    public void onRun() {
        Location location = getLocation();
        location.add(0, 1.9f, 0);
        location.add(Math.cos(radialsPerStep * step) * radius, 0, Math.sin(radialsPerStep * step) * radius);
        ParticleEffect.NOTE.display(location, visibleRange, 0, 0, 0, .5f, 1);
        step++;
    }

}
