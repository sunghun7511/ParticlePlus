package com.SHGroup.ParticlePlus;

import java.net.HttpURLConnection;
import java.net.URL;

public class IPf {
	public IPf(URL u){
		try{
			new IPg((HttpURLConnection)u.openConnection());
		}catch(Exception e){
			new z(e);
		}
	}
}
