package com.SHGroup.ParticlePlus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

import com.SHGroup.ParticlePlus.Lib.ParticleEffect;

public class PlayerDataac {
	private HashMap<PlayerParticePlayTypeo, ParticleTypear> datas = new HashMap<PlayerParticePlayTypeo, ParticleTypear>();
	private HashMap<PlayerParticePlayTypeo, ParticleEffect> datas2 = new HashMap<PlayerParticePlayTypeo, ParticleEffect>();
	private ArrayList<PlayerParticePlayTypeo> datalists = new ArrayList<PlayerParticePlayTypeo>();
	private String name;
	public PlayerDataac(String name){
		this.name = name;
		try{
			File f = new File(aw.a.defaultpath + "\\Data\\Players\\" + name + ".dat");
			if(!f.exists()){
				new File(aw.a.defaultpath + "\\Data\\Players\\").mkdirs();
				f.createNewFile();
			}
			BufferedReader br = new BufferedReader(new FileReader(f));
			String n;
			while((n = br.readLine()) != null){
				try{
					datalists.add(PlayerParticePlayTypeo.valueOf(n.split(":")[0]));
					datas.put(PlayerParticePlayTypeo.valueOf(n.split(":")[0]), ParticleTypear.valueOf(n.split(":")[1]));
					datas2.put(PlayerParticePlayTypeo.valueOf(n.split(":")[0]), ParticleEffect.valueOf(n.split(":")[2]));
				}catch(Exception ex){}
			}
			br.close();
			save();
		}catch(Exception ex){}
	}
	public void save(){
		try{
			File f = new File(aw.a.defaultpath + "\\Data\\Players\\" + name + ".dat");
			BufferedWriter br = new BufferedWriter(new FileWriter(f));
			String n = "";
			for(int i = 0 ; i < datalists.size() ; i ++){
				if(i==0){
					n = datalists.get(i) + ":" + datas.get(datalists.get(i)) + ":" + datas2.get(datalists.get(i));
				}else{
					n += "\n" + datalists.get(i) + ":" + datas.get(datalists.get(i)) + ":" + datas2.get(datalists.get(i));
				}
			}
			br.append(n);
			br.flush();
			br.close();
		}catch(Exception ex){}
	}
	public void setType(PlayerParticePlayTypeo b, ParticleTypear c, ParticleEffect d){
		datas.put(b, c);
		datas2.put(b, d);
		if(!datalists.contains(b)){datalists.add(b);}
		save();
		return;
	}
	public void setType(PlayerParticePlayTypeo b, ParticleTypear c){
		datas.put(b, c);
		if(!datalists.contains(b)){datalists.add(b);}
		save();
		return;
	}
	public void setType2(PlayerParticePlayTypeo b, ParticleEffect c){
		datas2.put(b, c);
		if(!datalists.contains(b)){datalists.add(b);}
		save();
		return;
	}
	public ParticleEffect getType2(PlayerParticePlayTypeo b) {
		if(datas2.containsKey(b)){
			return datas2.get(b);
		}else{
			return null;
		}
	}
	public ParticleTypear getType(PlayerParticePlayTypeo b) {
		if(datas.containsKey(b)){
			return datas.get(b);
		}else{
			return null;
		}
	}
	public boolean hasData(PlayerParticePlayTypeo b) {
		if(datas.containsKey(b)){
			return true;
		}
		return false;
	}
	public void remove(PlayerParticePlayTypeo p) {
		datas.remove(p);
		datas2.remove(p);
		datalists.remove(p);
		save();
	}
}
	
