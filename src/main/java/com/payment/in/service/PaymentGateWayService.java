package com.payment.in.service;

import com.payment.in.request.PaymentRequest;
import com.payment.in.response.PaymentResponse;

public interface PaymentGateWayService {
	/*
	 * POST Takes the client id , payment request object and starts the process with
	 * payment gateway which client was registered for and @returns the Redirect
	 * gateway URL
	 */
	PaymentResponse startTransaction(PaymentRequest paymentRequest) throws Exception;

	/*
	 * GET Takes the clientID and transactionID and
	 * 
	 * @returns status of transaction;
	 */
	String queryTransactionStatus(String transactionId);
}
