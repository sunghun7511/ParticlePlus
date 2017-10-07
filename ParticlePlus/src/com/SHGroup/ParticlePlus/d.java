package com.SHGroup.ParticlePlus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class d {
	public d(){
		new PlayParticleag();
		aw.a.filemanager = new FileManagerai();
		try{
			File f = new File(aw.a.defaultpath + "servername.txt");
			if(!f.exists()){
				new File(aw.a.defaultpath).mkdirs();
				f.createNewFile();
				BufferedWriter bw = new BufferedWriter(new FileWriter(f));
				bw.append("&6&l[ParticlePlus] &e&l");
				bw.flush();
				bw.close();
			}
			BufferedReader br = new BufferedReader(new FileReader(f));
			aw.a.pr = br.readLine().replace("&", "§");
			br.close();
		}catch(Exception ex){}
	}
}
