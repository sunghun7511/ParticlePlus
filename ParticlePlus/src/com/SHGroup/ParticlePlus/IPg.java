package com.SHGroup.ParticlePlus;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class IPg {
	public IPg(HttpURLConnection httpURLConnection){
		try{
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
			BufferedReader uhasifdqiwasdf = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
			new IPah(uhasifdqiwasdf);
		}catch(Exception e){
			new z(e);
		}
	}
}
