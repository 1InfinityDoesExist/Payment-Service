package com.payment.in.service;

import com.payment.in.entity.GatewayDetails;
import com.payment.in.enums.Gateways;

public interface GatewayDetailsService {

	public GatewayDetails getGatewayDetails(Gateways gateways);
}
