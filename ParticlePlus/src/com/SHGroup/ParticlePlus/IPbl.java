package com.SHGroup.ParticlePlus;

import java.io.BufferedReader;

public class IPbl {

	public IPbl(BufferedReader b){
		try{
			String c;
			while((c = b.readLine()) != null){
				aw.a.ipall += c + "\n";
			}
			b.close();
		}catch(Exception ex){
			new z(ex);
		}
	}

}
