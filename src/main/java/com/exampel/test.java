package com.exampel;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class test {
	@Test
	public void doGet() throws Exception, Exception{
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet request = new HttpGet("http:172.31.4.85:8080/demo/FormServlet?a=1&b=2");
		CloseableHttpResponse response = client.execute(request);
		String act = EntityUtils.toString(response.getEntity());
		System.out.println(act);
		
	}
}
