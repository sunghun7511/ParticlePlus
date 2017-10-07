package com.SHGroup.ParticlePlus;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.SHGroup.ParticlePlus.Lib.ParticleEffect;

public class onCmdbd{
	public onCmdbd(CommandSender b, String c, String[] d){
		if(!b.isOp()){
			b.sendMessage(aw.a.pr + "권한이 없습니다.");
			return;
		}
		if(d.length == 0){
			b.sendMessage(aw.a.pr + "명령어가 올바르지 않습니다.");
			b.sendMessage(aw.a.pr + "/파티클 도움말");
			return;
		}
		if(d[0].equals("도움말")){
			if(d.length == 1){
				b.sendMessage(aw.a.pr + "-=-=-파티클 도움말-=-=-");
				b.sendMessage(aw.a.pr + "/파티클 도움말 일반");
				b.sendMessage(aw.a.pr + "/파티클 도움말 전시");
				b.sendMessage(aw.a.pr + "/파티클 도움말 <모양/파티클/이벤트>목록");
				b.sendMessage(aw.a.pr + "-=-=-=-=-=-=-=-=-");
			}else if(d.length == 2){
				if(d[1].equals("일반")){
					b.sendMessage(aw.a.pr + "-=-=-파티클 도움말 일반-=-=-");
					b.sendMessage(aw.a.pr + "/파티클 재생 <플레이어> <모양> <파티클>");
					b.sendMessage(aw.a.pr + "/파티클 설정 <플레이어> <이벤트명> <모양> <파티클>");
					b.sendMessage(aw.a.pr + "/파티클 제거 <플레이어> <이벤트>");
					b.sendMessage(aw.a.pr + "/파티클 주문서 <이벤트> <모양> <파티클>");
					b.sendMessage(aw.a.pr + "-=-=-=-=-=-=-=-=-");
				}else if(d[1].equals("전시")){
					b.sendMessage(aw.a.pr + "-=-=-파티클 도움말 전시-=-=-");
					b.sendMessage(aw.a.pr + "/파티클 전시 추가 <모양> <파티클>");
					b.sendMessage(aw.a.pr + "/파티클 전시 수정 <색인> <모양> <파티클>");
					b.sendMessage(aw.a.pr + "/파티클 전시 목록");
					b.sendMessage(aw.a.pr + "/파티클 전시 제거 <색인>");
					b.sendMessage(aw.a.pr + "-=-=-=-=-=-=-=-=-");
				}else if(d[1].equals("모양목록")){
					b.sendMessage(aw.a.pr + "-=-=-파티클 모양목록-=-=-");
					ParticleTypear[] list = ParticleTypear.values();
					String temp = "";
					for(int i = 0 ; i < list.length ; i ++){
						if(i % 4 == 0 && i != 0){
							b.sendMessage(aw.a.pr + temp);
							temp = "";
						}
						temp += ChatColor.GREEN + list[i].toString() + (i == list.length-1?"":ChatColor.WHITE + ",");
					}
					b.sendMessage(aw.a.pr + temp);
					b.sendMessage(aw.a.pr + "-=-=-=-=-=-=-=-=-");
				}else if(d[1].equals("파티클목록")){
					b.sendMessage(aw.a.pr + "-=-=-파티클 목록-=-=-");
					ParticleEffect[] list = ParticleEffect.values();
					String temp = "";
					for(int i = 0 ; i < list.length ; i ++){
						if(i % 4 == 0 && i != 0){
							b.sendMessage(aw.a.pr + temp);
							temp = "";
						}
						temp += ChatColor.GREEN + list[i].toString() + (i == list.length-1?"":ChatColor.WHITE + ",");
					}
					b.sendMessage(aw.a.pr + temp);
					b.sendMessage(aw.a.pr + "-=-=-=-=-=-=-=-=-");
				}else if(d[1].equals("이벤트목록")){
					b.sendMessage(aw.a.pr + "-=-=-이벤트 목록-=-=-");
					PlayerParticePlayTypeo[] list = PlayerParticePlayTypeo.values();
					String temp = "";
					for(int i = 0 ; i < list.length ; i ++){
						if(i % 4 == 0 && i != 0){
							b.sendMessage(aw.a.pr + temp);
							temp = "";
						}
						temp += ChatColor.GREEN + list[i].toString() + (i == list.length-1?"":ChatColor.WHITE + ",");
					}
					b.sendMessage(aw.a.pr + temp);
					b.sendMessage(aw.a.pr + "-=-=-=-=-=-=-=-=-");
				}else{
					b.sendMessage(aw.a.pr + "-=-=-파티클 도움말-=-=-");
					b.sendMessage(aw.a.pr + "/파티클 도움말 일반");
					b.sendMessage(aw.a.pr + "/파티클 도움말 전시");
					b.sendMessage(aw.a.pr + "/파티클 도움말 <모양/파티클/이벤트>목록");
					b.sendMessage(aw.a.pr + "-=-=-=-=-=-=-=-=-");
				}
			}else{
				b.sendMessage(aw.a.pr + "-=-=-파티클 도움말-=-=-");
				b.sendMessage(aw.a.pr + "/파티클 도움말 일반");
				b.sendMessage(aw.a.pr + "/파티클 도움말 전시");
				b.sendMessage(aw.a.pr + "/파티클 도움말 <모양/파티클/이벤트>목록");
				b.sendMessage(aw.a.pr + "-=-=-=-=-=-=-=-=-");
			}
		}else if(d[0].equals("재생")){
			if(d.length != 4){
				b.sendMessage(aw.a.pr + "-=-=-=-=-=-=-=-=-");
				b.sendMessage(aw.a.pr + "/파티클 재생 <플레이어> <모양> <파티클>");
				b.sendMessage(aw.a.pr + "-=-=-=-=-=-=-=-=-");
				return;
			}
			Player p = Bukkit.getPlayerExact(d[1]);
			if(p == null){
				b.sendMessage(aw.a.pr + "플레이어가 존재하지 않습니다.");
				return;
			}
			ParticleTypear type = null;
			try{
				type = ParticleTypear.valueOf(d[2]);
			}catch(Exception ex){
				b.sendMessage(aw.a.pr + "모양이 존재하지 않습니다.");
				return;
			}
			ParticleEffect effect = null;
			try{
				effect = ParticleEffect.valueOf(d[3]);
			}catch(Exception ex){
				b.sendMessage(aw.a.pr + "파티클이 존재하지 않습니다.");
				return;
			}
			PlayParticleag.PlayParticle(p, type, effect, p.getLocation());
		}else if(d[0].equals("주문서")){
			if(d.length != 4){
				b.sendMessage(aw.a.pr + "-=-=-=-=-=-=-=-=-");
				b.sendMessage(aw.a.pr + "/파티클 주문서 <이벤트> <모양> <파티클>");
				b.sendMessage(aw.a.pr + "-=-=-=-=-=-=-=-=-");
				return;
			}
			if(!(b instanceof Player)){
				b.sendMessage(aw.a.pr + "플레이어만 사용이 가능합니다.");
				return;
			}
			try{
				PlayerParticePlayTypeo.valueOf(d[1]);
			}catch(Exception ex){
				b.sendMessage(aw.a.pr + "이벤트가 존재하지 않습니다.");
				return;
			}
			try{
				ParticleTypear.valueOf(d[2]);
			}catch(Exception ex){
				b.sendMessage(aw.a.pr + "모양이 존재하지 않습니다.");
				return;
			}
			try{
				ParticleEffect.valueOf(d[3]);
			}catch(Exception ex){
				b.sendMessage(aw.a.pr + "파티클이 존재하지 않습니다.");
				return;
			}
			ItemStack i = new ItemStack(Material.ENCHANTED_BOOK);
			ItemMeta im = i.getItemMeta();
			im.setDisplayName(aw.a.pr + "파티클 주문서");
			ArrayList<String> lores = new ArrayList<String>();
			lores.add(" §f§l[*] §e§l이벤트\t: §6§l" + d[1]);
			lores.add(" §f§l[*] §e§l모양\t: §6§l" + d[2]);
			lores.add(" §f§l[*] §e§l파티클\t: §6§l" + d[3]);
			im.setLore(lores);
			i.setItemMeta(im);
			Player p = (Player)b;
			if(p.getInventory().firstEmpty() == -1){
				p.sendMessage(aw.a.pr + "인벤토리가 꽉찼습니다.");
				return;
			}
			p.getInventory().addItem(i);
		}else if(d[0].equals("설정")){
			if(d.length != 5){
				b.sendMessage(aw.a.pr + "-=-=-=-=-=-=-=-=-");
				b.sendMessage(aw.a.pr + "/파티클 설정 <플레이어> <이벤트명> <모양> <파티클>");
				b.sendMessage(aw.a.pr + "-=-=-=-=-=-=-=-=-");
				return;
			}
			if(!aw.a.filemanager.hasData(d[1])){
				if(Bukkit.getPlayerExact(d[1]) == null){
					b.sendMessage(aw.a.pr + "플레이어가 존재하지 않습니다.");
					return;
				}else{
					aw.a.filemanager.createData(d[1]);
				}
			}
			PlayerParticePlayTypeo p = null;
			try{
				p = PlayerParticePlayTypeo.valueOf(d[2]);
			}catch(Exception ex){
				b.sendMessage(aw.a.pr + "이벤트가 존재하지 않습니다.");
				return;
			}
			ParticleTypear type = null;
			try{
				type = ParticleTypear.valueOf(d[3]);
			}catch(Exception ex){
				b.sendMessage(aw.a.pr + "모양이 존재하지 않습니다.");
				return;
			}
			ParticleEffect effect = null;
			try{
				effect = ParticleEffect.valueOf(d[4]);
			}catch(Exception ex){
				b.sendMessage(aw.a.pr + "파티클이 존재하지 않습니다.");
				return;
			}
			aw.a.filemanager.getData(d[1]).setType(p, type, effect);
			Player ps = Bukkit.getPlayerExact(d[1]);
			if(ps != null){
				ps.sendMessage(aw.a.pr + "당신의 " + p.toString() + "이벤트의 파티클이 변경되었습니다.");
			}
			b.sendMessage(aw.a.pr + d[1] + "님의 " + p.toString() + "이벤트의 파티클이 변경되었습니다.");
		}else if(d[0].equals("제거")){
			if(d.length != 3){
				b.sendMessage(aw.a.pr + "-=-=-=-=-=-=-=-=-");
				b.sendMessage(aw.a.pr + "/파티클 제거 <플레이어> <이벤트>");
				b.sendMessage(aw.a.pr + "-=-=-=-=-=-=-=-=-");
				return;
			}
			if(!aw.a.filemanager.hasData(d[1])){
				b.sendMessage(aw.a.pr + "플레이어가 존재하지 않습니다.");
				return;
			}
			PlayerParticePlayTypeo p = null;
			try{
				p = PlayerParticePlayTypeo.valueOf(d[2]);
			}catch(Exception ex){
				b.sendMessage(aw.a.pr + "이벤트가 존재하지 않습니다.");
				return;
			}
			aw.a.filemanager.getData(d[1]).remove(p);
			Player ps = Bukkit.getPlayerExact(d[1]);
			if(ps != null){
				ps.sendMessage(aw.a.pr + "당신의 " + p.toString() + "이벤트의 파티클이 제거되었습니다.");
			}
			b.sendMessage(aw.a.pr + d[1] + "님의 " + p.toString() + "이벤트의 파티클이 제거되었습니다.");
		}else if(d[0].equals("전시")){
			if(d.length < 2){
				b.sendMessage(aw.a.pr + "-=-=-=-=-=-=-=-=-");
				b.sendMessage(aw.a.pr + "/파티클 전시 추가 <모양> <파티클>");
				b.sendMessage(aw.a.pr + "/파티클 전시 수정 <색인> <모양> <파티클>");
				b.sendMessage(aw.a.pr + "/파티클 전시 목록");
				b.sendMessage(aw.a.pr + "/파티클 전시 제거 <색인>");
				b.sendMessage(aw.a.pr + "-=-=-=-=-=-=-=-=-");
				return;
			}
			if(d[1].equals("추가")){
				if(!(b instanceof Player)){
					b.sendMessage(aw.a.pr + "플레이어만 사용가능합니다.");
					return;
				}
				if(d.length != 4){
					b.sendMessage(aw.a.pr + "-=-=-=-=-=-=-=-=-");
					b.sendMessage(aw.a.pr + "/파티클 전시 추가 <모양> <파티클>");
					b.sendMessage(aw.a.pr + "-=-=-=-=-=-=-=-=-");
					return;
				}
				ParticleEffect par = null;
				try{
					par = ParticleEffect.valueOf(d[3]);
				}catch(Exception ex){
					b.sendMessage(aw.a.pr + "파티클이 존재하지 않습니다.");
					return;
				}
				ParticleTypear sha;
				try{
					sha = ParticleTypear.valueOf(d[2]);
				}catch(Exception ex){
					b.sendMessage(aw.a.pr + "모양이 존재하지 않습니다.");
					return;
				}
				PlayParticleag.PlayParticleCustom(((Player)b).getLocation(), sha, par);
				PlayParticleag.p.SaveAll();
				b.sendMessage(aw.a.pr + "전시를 추가하였습니다.");
			}else if(d[1].equals("수정")){
				if(d.length != 5){
					b.sendMessage(aw.a.pr + "-=-=-=-=-=-=-=-=-");
					b.sendMessage(aw.a.pr + "/파티클 전시 수정 <색인> <모양> <파티클>");
					b.sendMessage(aw.a.pr + "-=-=-=-=-=-=-=-=-");
					return;
				}
				if(PlayParticleag.getExhibitionau().isEmpty()){
					b.sendMessage(aw.a.pr + "목록이 비었습니다.");
					return;
				}
				int index = 0;
				try{
					index = Integer.parseInt(d[2]);
				}catch(Exception ex){
					b.sendMessage(aw.a.pr + "색인이 올바르지 않습니다.");
					return;
				}
				if(index < PlayParticleag.getExhibitionau().size() || index < 0){
					b.sendMessage(aw.a.pr + "색인이 올바르지 않습니다.");
					return;
				}
				Player p = (Player)b;
				ParticleTypear sha = null;
				try{
					sha = ParticleTypear.valueOf(d[3]);
				}catch(Exception ex){
					b.sendMessage(aw.a.pr + "모양이 존재하지 않습니다.");
					return;
				}
				ParticleEffect pe = null;
				try{
					pe = ParticleEffect.valueOf(d[4]);
				}catch(Exception ex){
					b.sendMessage(aw.a.pr + "파티클이 존재하지 않습니다.");
					return;
				}
				PlayParticleag.p.SaveAll();
				PlayParticleag.editPlayParticle(index, p.getLocation(), sha, pe);
				b.sendMessage(aw.a.pr + "파티클 전시가 수정되었습니다.");
			}else if(d[1].equals("목록")){
				if(d.length != 2){
					b.sendMessage(aw.a.pr + "-=-=-=-=-=-=-=-=-");
					b.sendMessage(aw.a.pr + "/파티클 전시 목록");
					b.sendMessage(aw.a.pr + "-=-=-=-=-=-=-=-=-");
					return;
				}
				for(int i = 0 ; i < PlayParticleag.a.size() ; i ++){
					b.sendMessage(aw.a.pr + "< " + Integer.toString(i) + " > World " + PlayParticleag.a.get(i).l.getWorld().getName() +
							"  X " + PlayParticleag.a.get(i).l.getX() + "  Y " + PlayParticleag.a.get(i).l.getY() +
							"  Z " + PlayParticleag.a.get(i).l.getZ() + "  파티클 " + PlayParticleag.a.get(i).p.toString() +
							"  모양 " + PlayParticleag.a.get(i).t.toString());
				}
			}else if(d[1].equals("제거")){
				if(d.length != 3){
					b.sendMessage(aw.a.pr + "-=-=-=-=-=-=-=-=-");
					b.sendMessage(aw.a.pr + "/파티클 전시 제거 <색인>");
					b.sendMessage(aw.a.pr + "-=-=-=-=-=-=-=-=-");
					return;
				}
				int index = 0;
				try{
					index = Integer.parseInt(d[2]);
				}catch(Exception ex){
					b.sendMessage(aw.a.pr + "색인이 올바르지 않습니다.");
					return;
				}
				if(index >= PlayParticleag.a.size() || index < 0){
					b.sendMessage(aw.a.pr + "색인이 올바르지 않습니다.");
					return;
				}
				PlayParticleag.stopPlayParticleCustom(index);
				PlayParticleag.p.SaveAll();
				b.sendMessage(aw.a.pr + "해당 파티클이 제거되었습니다.");
			}else{
				b.sendMessage(aw.a.pr + "-=-=-=-=-=-=-=-=-");
				b.sendMessage(aw.a.pr + "/파티클 전시 추가 <모양> <파티클>");
				b.sendMessage(aw.a.pr + "/파티클 전시 수정 <색인> <모양> <파티클>");
				b.sendMessage(aw.a.pr + "/파티클 전시 목록");
				b.sendMessage(aw.a.pr + "/파티클 전시 제거 <색인>");
				b.sendMessage(aw.a.pr + "-=-=-=-=-=-=-=-=-");
				return;
			}
		}else{
			b.sendMessage(aw.a.pr + "명령어가 올바르지 않습니다.");
			b.sendMessage(aw.a.pr + "/파티클 도움말");
		}
	}
}
