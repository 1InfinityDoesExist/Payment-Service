package com.payment.in.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.payment.in.request.PaymentRequest;
import com.payment.in.service.PaymentGateWayService;

@RestController
public class AuthorizeNetController {

	@Autowired
	private Map<String, PaymentGateWayService> gatewayClassHashMap;

	@PostMapping("/payment")
	public ResponseEntity<?> creditToMerchantUsingCard(@RequestBody PaymentRequest paymentRequest) throws Exception {

		PaymentGateWayService paymentGateWayService = gatewayClassHashMap.get(paymentRequest.getGatewayName());
		return ResponseEntity.status(HttpStatus.OK).body(paymentGateWayService.startTransaction(paymentRequest));
	}

}
