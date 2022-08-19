package com.payment.in.config;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Feign;
import feign.Logger;
import feign.codec.ErrorDecoder;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;

@Configuration
public class FeignConfig {

	@Value("${feign.client.max_idle_connections:10}")
	private int maxIdleConnections;
	@Value("${feign.client.keep_alive_duration:50000}")
	private long keepAliveDuration;

	@Bean
	public OkHttpClient feignClientBean() {

		ConnectionPool connectionPool = new ConnectionPool(maxIdleConnections, keepAliveDuration,
				TimeUnit.MILLISECONDS);
		OkHttpClient client = new OkHttpClient().newBuilder().connectionPool(connectionPool)
				.connectTimeout(1000, TimeUnit.MILLISECONDS).readTimeout(1000, TimeUnit.MILLISECONDS)
				.followRedirects(false).retryOnConnectionFailure(false).build();
		return client;
	}

	@Bean
	public Feign.Builder feignBuilder() {
		return new Feign.Builder();
	}

	@Bean
	public Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}

	@Bean
	public ErrorDecoder feignErrorDecoder() {
		return new FeignErrorHandler();
	}
}