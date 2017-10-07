package com.SHGroup.ParticlePlus.Lib;

import org.bukkit.Location;

public class IconEffect extends Effect {

    /**
     * ParticleType of spawned particle
     */
    public ParticleEffect particle = ParticleEffect.VILLAGER_ANGRY;

    public int yOffset = 2;

    public IconEffect(EffectManager effectManager) {
        super(effectManager);
        type = EffectType.REPEATING;
        period = 4;
        iterations = 25;
    }

    @Override
    public void onRun() {
        Location location = getLocation();
        location.add(0, yOffset, 0);
        display(particle, location);
    }
}
