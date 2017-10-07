package com.SHGroup.ParticlePlus;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;

import com.SHGroup.ParticlePlus.Lib.ParticleEffect;

public class Listenerax implements Listener{
	@EventHandler
	public void a(PlayerJoinEvent b){
		if(aw.a.filemanager.hasData(b.getPlayer().getName())){
			if(aw.a.filemanager.getData(b.getPlayer().getName()).hasData(PlayerParticePlayTypeo.JOIN)){
				PlayParticleag.PlayParticle(b.getPlayer(), PlayerParticePlayTypeo.JOIN, null);
			}
		}
	}
	@EventHandler
	public void b(PlayerLevelChangeEvent b){
		if(b.getNewLevel() > b.getOldLevel()){
			if(aw.a.filemanager.hasData(b.getPlayer().getName())){
				if(aw.a.filemanager.getData(b.getPlayer().getName()).hasData(PlayerParticePlayTypeo.LEVELUP)){
					PlayParticleag.PlayParticle(b.getPlayer(), PlayerParticePlayTypeo.LEVELUP, null);
				}
			}
		}
	}
	@EventHandler
	public void c(AsyncPlayerChatEvent b){
		if(aw.a.filemanager.hasData(b.getPlayer().getName())){
			if(aw.a.filemanager.getData(b.getPlayer().getName()).hasData(PlayerParticePlayTypeo.CHAT)){
				PlayParticleag.PlayParticle(b.getPlayer(), PlayerParticePlayTypeo.CHAT, null);
			}
		}
	}
	@EventHandler
	public void f(PlayerInteractEvent b){
		if(b.getItem() != null){
			if(b.getItem().hasItemMeta()){
				try{
					if(b.getItem().getType() == Material.ENCHANTED_BOOK){
						if(b.getItem().getItemMeta().getDisplayName().equals(aw.a.pr + "파티클 주문서")){
							ArrayList<String> lore = (ArrayList<String>)b.getItem().getItemMeta().getLore();
							if(b.getItem().getAmount() == 1){
								b.getPlayer().setItemInHand(new ItemStack(Material.AIR));
							}else{
								ItemStack ii = b.getItem();
								ii.setAmount(ii.getAmount() - 1);
								b.getPlayer().setItemInHand(ii);
							}
							PlayerParticePlayTypeo p = PlayerParticePlayTypeo.valueOf(lore.get(0).replace(" §f§l[*] §e§l이벤트\t: §6§l", ""));
							ParticleTypear s = ParticleTypear.valueOf(lore.get(1).replace(" §f§l[*] §e§l모양\t: §6§l", ""));
							ParticleEffect t = ParticleEffect.valueOf(lore.get(2).replace(" §f§l[*] §e§l파티클\t: §6§l", ""));
							aw.a.filemanager.getData(b.getPlayer().getName()).setType(p, s, t);
							b.getPlayer().sendMessage(aw.a.pr + "당신의 " + p.toString() + "이벤트의 파티클이 변경되었습니다.");
						}
					}
				}catch(Exception ex){}
			}
		}
	}
	@EventHandler
	public void d(PlayerMoveEvent b){
		if(aw.a.filemanager.hasData(b.getPlayer().getName())){
			if(aw.a.filemanager.getData(b.getPlayer().getName()).hasData(PlayerParticePlayTypeo.MOVE)){
				PlayParticleag.PlayParticle(b.getPlayer(), PlayerParticePlayTypeo.MOVE, null);
			}
		}
	}
	@EventHandler
	public void e(PlayerQuitEvent b){
		if(aw.a.filemanager.hasData(b.getPlayer().getName())){
			if(aw.a.filemanager.getData(b.getPlayer().getName()).hasData(PlayerParticePlayTypeo.QUIT)){
				PlayParticleag.PlayParticle(b.getPlayer(), PlayerParticePlayTypeo.QUIT, null);
			}
		}
	}
	@EventHandler
	public void f(PlayerTeleportEvent b){
		if(aw.a.filemanager.hasData(b.getPlayer().getName())){
			if(aw.a.filemanager.getData(b.getPlayer().getName()).hasData(PlayerParticePlayTypeo.TELEPORT_From)){
				PlayParticleag.PlayParticle(b.getPlayer(), PlayerParticePlayTypeo.TELEPORT_From, b.getFrom());
			}
			if(aw.a.filemanager.getData(b.getPlayer().getName()).hasData(PlayerParticePlayTypeo.TELEPORT_To)){
				PlayParticleag.PlayParticle(b.getPlayer(), PlayerParticePlayTypeo.TELEPORT_To, b.getTo());
			}
		}
	}
}
