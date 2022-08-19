package com.payment.in.config;

import org.springframework.stereotype.Component;

import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class FeignErrorHandler implements ErrorDecoder {

	@Override
	public Exception decode(String s, Response response) {

		String msg = "Status Code : " + response.status() + ", Reason : " + response.reason();
		if (response.status() >= 400 && response.status() < 500) {
			return new RuntimeException();
		}
		if (response.status() >= 500 && response.status() < 600) {
			return new RuntimeException();
		}
		return new Exception(msg);
	}

}
