package com.SHGroup.ParticlePlus.Lib;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class BleedEffect extends com.SHGroup.ParticlePlus.Lib.Effect {

    /**
     * Play the Hurt Effect for the Player
     */
    public boolean hurt = true;


    @Deprecated
    public int duration = 10;


    public int color = 152;

    public BleedEffect(EffectManager effectManager) {
        super(effectManager);
        type = EffectType.REPEATING;
        period = 4;
        iterations = 25;
    }

    @Override
    public void onRun() {
        Location location = getLocation();
        location.add(0, RandomUtils.random.nextFloat() * 1.75f, 0);
        location.getWorld().playEffect(location, Effect.STEP_SOUND, color);

        Entity entity = getEntity();
        if (hurt && entity != null) {
            entity.playEffect(org.bukkit.EntityEffect.HURT);
        }
    }
}
