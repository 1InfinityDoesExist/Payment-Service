package com.payment.in.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.payment.in.config.AuthorizeNetFeignClient;
import com.payment.in.entity.Customer;
import com.payment.in.entity.GatewayDetails;
import com.payment.in.model.CreateCustomerProfileRequest;
import com.payment.in.model.CustomerProfileType;
import com.payment.in.model.MerchantAuthenticationType;
import com.payment.in.repository.CustomerRepository;
import com.payment.in.request.PaymentRequest;
import com.payment.in.response.CreateCustomerProfileResponse;
import com.payment.in.service.CustomerDetailsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Transactional(rollbackFor = Exception.class)
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AuthorizeNetFeignClient authorizeNetFeignClient;

	@Override
	public Customer getCustomerDetails(PaymentRequest paymentRequest, GatewayDetails gatewayDetails) {

		Customer customer = customerRepository.findCustomerByEmailId(paymentRequest.getCustomer().getEmailId());
		if (ObjectUtils.isEmpty(customer)) {
			customer.setProfileId(createCustomerProfile(customer, gatewayDetails));
			customerRepository.save(customer);
		}
		return customer;
	}

	private String createCustomerProfile(Customer customer, GatewayDetails gatewayDetails) {
		log.info("-----Creating customer profile id-----");

		MerchantAuthenticationType merchantAuthenticationType = new MerchantAuthenticationType();
		merchantAuthenticationType.setName(gatewayDetails.getStoreId());
		merchantAuthenticationType.setTransactionKey(gatewayDetails.getStorePwd());

		CustomerProfileType customerProfileType = new CustomerProfileType();
		customerProfileType.setMerchantCustomerId(customer.getMobile());
		customerProfileType.setEmail(customer.getEmailId());

		CreateCustomerProfileRequest createCustomerProfileRequest = new CreateCustomerProfileRequest();
		createCustomerProfileRequest.setMerchantAuthentication(merchantAuthenticationType);
		createCustomerProfileRequest.setProfile(customerProfileType);

		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("createCustomerProfileRequest", createCustomerProfileRequest);

		log.info("createCustomerProfileRequest : {}", hashMap);

		CreateCustomerProfileResponse createCustomerProfileResponse = authorizeNetFeignClient
				.createCustomerProfileRequest(hashMap);

		if (ObjectUtils.isEmpty(createCustomerProfileResponse)
				|| ObjectUtils.isEmpty(createCustomerProfileResponse.getCustomerProfileId())) {
			log.error("error while connecting to Authorize.Net payment gateway {}", createCustomerProfileResponse);
			throw new RuntimeException("Unable to connect to gateway");
		}

		log.info("CreateCustomerProfile : created customer profile id - {} ",
				createCustomerProfileResponse.getCustomerProfileId());

		return createCustomerProfileResponse.getCustomerProfileId();

//		return null;
	}

}
