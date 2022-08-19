package com.payment.in.model;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Data
public class AuthCaptureRequest implements Serializable {
	private String transactionType;
	private BigDecimal amount;

	// private String currencyCode;
	private CustomerProfilePaymentType profile;
	private OrderType order;
	private CustomerEmail customer;

	private CustomerBillTo billTo;
}
