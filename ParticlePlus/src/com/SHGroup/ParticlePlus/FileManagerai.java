package com.SHGroup.ParticlePlus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import com.SHGroup.ParticlePlus.Lib.ParticleEffect;

public class FileManagerai {
	public boolean hasData(String name) {
		try{
			File f = new File(aw.a.defaultpath + "\\Data\\Players\\" + name + ".dat");
			if(f.exists()){
				return true;
			}else{
				new File(aw.a.defaultpath + "\\Data\\Players\\").mkdirs();
				return false;
			}
		}catch(Exception ex){
			return false;
		}
	}
	public PlayerDataac getData(String name) {
		try{
			PlayerDataac data = new PlayerDataac(name);
			return data;
		}catch(Exception ex){
			return null;
		}
	}
	public static void load(){
		try{
			File f = new File(aw.a.defaultpath + "\\Data\\exhibition.dat");
			if(!f.exists()){
				try{new File(aw.a.defaultpath + "\\Data\\").mkdirs();}catch(Exception e){}
				f.createNewFile();
			}
			BufferedReader br = new BufferedReader(new FileReader(f));
			String n;
			while((n = br.readLine()) != null){
				try{
					Location l = null;
					ParticleEffect e = null;
					ParticleTypear p = null;
					String[] n1 = n.split(":")[0].split("_");
					l = new Location(Bukkit.getWorld(n1[0]), Double.parseDouble(n1[1]), Double.parseDouble(n1[2]), Double.parseDouble(n1[3]));
					String n2 = n.split(":")[1];
					e = ParticleEffect.valueOf(n2);
					String n3 = n.split(":")[2];
					p = ParticleTypear.valueOf(n3);
					PlayParticleag.a.add(new Exhibitionau(l, e, p));
				}catch(Exception ex){}
			}
			br.close();
			return;
		}catch(Exception ex){
			return;
		}
	}
	public void createData(String name) {
		new PlayerDataac(name);
	}
}

