package com.goldilocks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpCaller {
	
	 public static void main(String[] args) throws Exception{
		String urlAddress="http://127.0.0.1:8999/test?value=p";
		URL url;
		String line;
		HttpURLConnection connection;
		try {
			url = new URL(urlAddress);
			connection=(HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
		int resCode=connection.getResponseCode();
		System.out.println(resCode);
		if(resCode != 200) {
			connection.disconnect();
			throw new Exception("Wrong Response Received");
		}
		BufferedReader reader=new BufferedReader(new InputStreamReader(connection.getInputStream()));
		StringBuilder sb=new StringBuilder();
		while((line=reader.readLine())!=null) {
			sb.append(line);
		}
		reader.close();
		connection.disconnect();
			System.out.println(sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			
		
	}
}
