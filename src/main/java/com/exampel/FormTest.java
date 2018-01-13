package com.exampel;

import org.testng.annotations.Test;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.databene.benerator.anno.Source;
import org.databene.feed4testng.FeedTest;
import org.w3c.dom.Entity;

import junit.framework.Assert;

public class FormTest extends FeedTest{
	@Test (dataProvider = "feeder")
	@Source("./data/add.csv")
	public static void doGet(String a,String b, String expected) throws Exception{
		CloseableHttpClient client = HttpClients.createDefault();
		try {
//			URI uri = new URIBuilder()
//					.setScheme("http")
//					.setHost("172.31.4.187")
//					.setPort(8080)
//					.setPath("/demo/FormServlet")
//					.setParameter("a","1")
//					.setParameter("b","3")
//					.build();
			HttpGet request = new HttpGet("172.31.4.85:8080/demo/FormServlet?a="+a+"&b="+b);
			CloseableHttpResponse response = client.execute(request);
			try {
				String act = EntityUtils.toString(response.getEntity());
				System.out.println(a);
			Assert.assertEquals(act, expected);
				
			} finally {
				// TODO: handle finally clause
				response.close();
			}
		} finally {
			// TODO: handle finally clause
			client.close();
		}
	}
}
