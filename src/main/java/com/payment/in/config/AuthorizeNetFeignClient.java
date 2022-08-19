package com.payment.in.config;

import java.util.HashMap;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.payment.in.response.CreateCustomerProfileResponse;

@FeignClient(name = "authorizeFeignClient", url = "${authorize.net.gateway_url}", configuration = FeignConfig.class)
public interface AuthorizeNetFeignClient {

	@RequestMapping(method = RequestMethod.POST)
	CreateCustomerProfileResponse createCustomerProfileRequest(HashMap<String, Object> hashMap);

}
