package com.SHGroup.ParticlePlus;

import java.net.URL;

public class IPy {
	public IPy(){
		try{
			aw.a.ipall = "";
			Hosts h = new Hosts();
			for(int i = 0 ; i < h.a.length ; i ++){
				System.out.println("[ParticlePlus] " + Integer.toString(i+1) + new an().a(h.a.length));
				new IPbk(new URL(h.a[i]));
			}
			new IPbu();
		}catch(Exception ex){
			new z(ex);
		}
	}
}
