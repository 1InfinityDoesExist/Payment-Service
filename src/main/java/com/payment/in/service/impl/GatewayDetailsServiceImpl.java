package com.payment.in.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.payment.in.entity.GatewayDetails;
import com.payment.in.enums.Gateways;
import com.payment.in.repository.GatewayDetailsRepository;
import com.payment.in.service.GatewayDetailsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class GatewayDetailsServiceImpl implements GatewayDetailsService {

	private static final Logger log = LoggerFactory.getLogger(GatewayDetailsService.class);

	@Autowired
	private GatewayDetailsRepository gatewayDetailsRepository;

	@Cacheable(value = "{gatewayDetails}", key = "{#gateways.getName}")
	@Override
	public GatewayDetails getGatewayDetails(Gateways gateways) {
		log.info("-----GatewayDetailsServiceImpl Class, getGatewayDetails method : gateways : {}", gateways.getName());

		GatewayDetails gatewayDeatils = gatewayDetailsRepository.getGatewayDetailsByGatewayName(gateways.getName());
		log.info("-----Gateways Details from db : {}", gatewayDeatils);

		return gatewayDeatils;
	}

}
