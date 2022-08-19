package com.payment.in.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.payment.in.handlers.PaymentInterceptor;

@SuppressWarnings("deprecation")
@Component
public class PaymentInterceptorConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private PaymentInterceptor paymentInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(paymentInterceptor);
	}
}
