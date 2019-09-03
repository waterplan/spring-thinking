package com.example.httpclient.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpClientTest {
	
	public void httpClient() throws ClientProtocolException, IOException {
		
//		httpClient.execute()
	}
	
	public static void main(String[] args) {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpUriRequest uri = new HttpPost("https://www.douban.com/");
		try {
			HttpResponse response = httpClient.execute(uri);
			HttpEntity entity = response.getEntity();
			InputStream content = entity.getContent();
			File file = new File("d://workFile/douban.txt");
			file.createNewFile();
			FileOutputStream outputStream = new FileOutputStream(file);
			byte[] bs = new byte[1024];
			while(content.read(bs)> 0) {
			outputStream.write(bs);
			outputStream.flush();
			}
			
			
			content.close();
			outputStream.close();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
