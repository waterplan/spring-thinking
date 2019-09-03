package com.example.thinking.common.util;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HttpUtil {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(HttpUtil.class);
	
	@Value("${connection.connectTimeout}")
	private int connectTime;
	
	@Autowired
	private HttpClient client;
	
	public HttpResponse postRequest(String url)  {
		RequestConfig config = RequestConfig.custom().setConnectionRequestTimeout(connectTime).
				setConnectTimeout(connectTime).setSocketTimeout(connectTime).build();
		HttpRequestBase httpBase = new HttpPost(url);
		httpBase.setConfig(config);
		HttpResponse execute;
		try {
			execute = client.execute(httpBase);
			return execute;
		} catch (ClientProtocolException e) {
			LOGGER.error("httpUtil: "+e.getMessage());
		} catch (IOException e) {
			LOGGER.error("httpUtil: "+e.getMessage());
		}
		return null;
	}

}
