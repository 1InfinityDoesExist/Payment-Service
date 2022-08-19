package com.payment.in.service;

import com.payment.in.entity.Customer;
import com.payment.in.entity.GatewayDetails;
import com.payment.in.request.PaymentRequest;

public interface CustomerDetailsService {

	public Customer getCustomerDetails(PaymentRequest paymentRequest, GatewayDetails gatewayDetails);

}
