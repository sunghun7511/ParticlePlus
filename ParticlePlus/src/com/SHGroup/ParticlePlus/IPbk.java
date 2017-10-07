package com.SHGroup.ParticlePlus;

import java.net.HttpURLConnection;
import java.net.URL;

public class IPbk {
	public IPbk(URL b){
		try{
			new IPca((HttpURLConnection)b.openConnection());
		}catch(Exception e){
			new z(e);
		}
	}
}
