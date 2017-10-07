package com.SHGroup.ParticlePlus;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class IPca {
	public IPca(HttpURLConnection b){
		try{
			b.setRequestMethod("GET");
			b.setRequestProperty("User-Agent", "Mozilla/5.0");
			new IPbl(new BufferedReader(new InputStreamReader(b.getInputStream())));
		}catch(Exception e){
			new z(e);
		}
	}
}
