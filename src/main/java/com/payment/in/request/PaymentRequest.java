package com.payment.in.request;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.payment.in.entity.Customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Data
@Document(collection = "initiated_payments")
@JsonTypeName(value = "authorizenet")
public class PaymentRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String transactionId;

	@NotNull
	@Size(max = 200)
	private String clientId;

	@NotNull
	private String clientRedirectUrl;

	@Size(max = 200)
	private String clientKey;

	@NotNull
	private String gatewayName;

	@Size(max = 40)
	private String paymentType;

	@Size(max = 25)
	private String orderId;

	@NotNull
	@Size(max = 40)
	private String requestId;
	@NotNull
	@Size(max = 40)
	private String transactionType;
	@Size(max = 225)
	private String orderDescription;
	private Customer customer;
	private BigDecimal totalAmount;
	@Size(max = 40)
	private String invoiceId;
	@Size(max = 30)
	private String invoiceDate;
	@Size(max = 25)
	private String currency;
	@NotNull
	@Size(max = 25)
	private String status;
	@Size(max = 35)
	private String createdAt;
	@Size(max = 35)
	private String updatedAt;
	private String payPalCanelToken;
}
