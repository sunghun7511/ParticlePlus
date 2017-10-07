package com.SHGroup.ParticlePlus.Lib;

import java.util.List;

import org.bukkit.event.HandlerList;

import com.SHGroup.ParticlePlus.aw;

public final class EffectLib{

	private static EffectLib instance;
	private EntityManager entityManager;
	public aw a;

	public EffectLib(aw a) {
		entityManager = new EntityManager(this);
        EffectManager.initialize();
		instance = this;
	}
	
	public void disable(){
		entityManager.dispose();
        EffectManager.disposeAll();
		HandlerList.unregisterAll(a);
	}
	
	public static EffectLib instance() {
		return instance;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public List<EffectManager> getEffectManagers() {
		return EffectManager.getManagers();
	}

}
