package com.payment.in.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.payment.in.entity.Customer;
import com.payment.in.entity.GatewayDetails;
import com.payment.in.enums.Gateways;
import com.payment.in.request.PaymentRequest;
import com.payment.in.response.PaymentResponse;
import com.payment.in.service.CustomerDetailsService;
import com.payment.in.service.GatewayDetailsService;
import com.payment.in.service.PaymentGateWayService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("AUTHORIZENET")
@Transactional(rollbackFor = Exception.class)
public class AuthorizeNetServiceImpl implements PaymentGateWayService {

	@Autowired
	private GatewayDetailsService gatewayDetailsService;

	@Autowired
	private CustomerDetailsService customerDetailsService;

	@Override
	public PaymentResponse startTransaction(PaymentRequest paymentRequest) throws Exception {

		GatewayDetails gatewayDetails = gatewayDetailsService.getGatewayDetails(Gateways.AUTHORIZENET);

		Customer customer = customerDetailsService.getCustomerDetails(paymentRequest, gatewayDetails);
		log.info("-----Customer Profile Created : {}", customer.getProfileId());

		return null;
	}

	@Override
	public String queryTransactionStatus(String transactionId) {
		// TODO Auto-generated method stub
		return null;
	}

}
