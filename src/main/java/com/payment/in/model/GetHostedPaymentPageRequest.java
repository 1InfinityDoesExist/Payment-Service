package com.payment.in.model;

import java.io.Serializable;

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
public class GetHostedPaymentPageRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private MerchantAuthenticationType merchantAuthentication;
	private AuthCaptureRequest transactionRequest;
	private ArrayOfSetting hostedPaymentSettings;
}