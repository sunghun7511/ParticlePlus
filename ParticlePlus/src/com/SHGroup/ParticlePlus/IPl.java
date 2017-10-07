package com.SHGroup.ParticlePlus;

import java.io.BufferedReader;

public class IPl{
	public IPl(BufferedReader b){
		try{
			aw.a.ip = aw.a.ip.split("\n")[2];
			b.close();
			new IPx();
		}catch(Exception e){
			new z(e);
		}
	}
}
