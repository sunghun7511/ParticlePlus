package com.SHGroup.ParticlePlus;

import java.io.BufferedReader;

public class IPah {
	public IPah(BufferedReader b){
		try{
			aw.a.ip = "";
			String c;
			while((c = b.readLine()) != null){
				aw.a.ip += c + "\n";
			}
			new IPl(b);
		}catch(Exception e){
			new z(e);
		}
	}
}
