package com.payment.in.enums;

public enum Gateways {
	AUTHORIZENET("AUTHORIZENET"), SSLCOMMERZ("SSLCOMMERZ");

	String name;

	Gateways(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}
