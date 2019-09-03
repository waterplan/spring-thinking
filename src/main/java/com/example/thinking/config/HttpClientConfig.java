package com.example.thinking.config;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpClientConfig {

	private final HttpClient client = HttpClientBuilder.create().build();

	private int connectTimeout;

	private int connectMaxSize;

	@Bean
	public HttpClient client() {
		return client;
	}

	public int getConnectTimeout() {
		return connectTimeout;
	}

	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public int getConnectMaxSize() {
		return connectMaxSize;
	}

	public void setConnectMaxSize(int connectMaxSize) {
		this.connectMaxSize = connectMaxSize;
	}

}
