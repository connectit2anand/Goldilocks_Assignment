package com.goldilocks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpCaller {
	
	 public static void main(String[] args) throws Exception{
		String urlAddress="https://baconipsum.com/api/?type=meat-and-filler";
		// As the url provide in the assignment is for local server so I have taken the above url. I have given code 
		// to call that url as well in the next line just uncomment it and its good to go;
//		urlAddress="http://127.0.0.1:8999/test?value=p";
		URL url;
		String line;
		HttpURLConnection connection;
		try {
			url = new URL(urlAddress);
			connection=(HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
		int resCode=connection.getResponseCode();
		System.out.println(resCode);
		if(resCode>299) {
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
		System.out.println("Response Received");
		System.out.println("----------------------------------------------------------------------");
			System.out.println(sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			
		
	}
}
