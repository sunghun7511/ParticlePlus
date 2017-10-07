package com.SHGroup.ParticlePlus.Lib;

import org.bukkit.Location;
import org.bukkit.Sound;

public class ExplodeEffect extends Effect {

    /**
     * Amount of spawned smoke-sparks
     */
    public int amount = 25;


    public float speed = .5f;

    public Sound sound = Sound.EXPLODE;

    public ExplodeEffect(EffectManager effectManager) {
        super(effectManager);
        type = EffectType.INSTANT;
    }

    @SuppressWarnings("deprecation")
	@Override
    public void onRun() {
        Location location = getLocation();
        location.getWorld().playSound(location, sound, 4.0F, (1.0F + (RandomUtils.random.nextFloat() - RandomUtils.random.nextFloat()) * 0.2F) * 0.7F);
        ParticleEffect.EXPLOSION_NORMAL.display(location, visibleRange, 0, 0, 0, speed, amount);
        ParticleEffect.EXPLOSION_HUGE.display(location, visibleRange, 0, 0, 0, 0, amount);
    }

}
