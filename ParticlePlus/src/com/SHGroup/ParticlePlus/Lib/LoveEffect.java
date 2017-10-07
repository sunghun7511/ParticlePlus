package com.SHGroup.ParticlePlus.Lib;

import org.bukkit.Location;

public class LoveEffect extends Effect {

    /**
     * Particle to display
     */
    public ParticleEffect particle = ParticleEffect.HEART;

    public LoveEffect(EffectManager effectManager) {
        super(effectManager);
        type = EffectType.REPEATING;
        period = 2;
        iterations = 600;
    }

    @Override
    public void onRun() {
        Location location = getLocation();
        location.add(RandomUtils.getRandomCircleVector().multiply(RandomUtils.random.nextDouble() * 0.6d));
        location.add(0, RandomUtils.random.nextFloat() * 2, 0);
        display(particle, location);
    }

}
