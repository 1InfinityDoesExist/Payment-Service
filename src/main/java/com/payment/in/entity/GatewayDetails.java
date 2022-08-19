package com.payment.in.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
@Document(collection = "gateway_details")
public class GatewayDetails implements Serializable {
	@Id
	private String gatewayName; // AUTHORIZENET
	@NotNull
	private String storeId; // api login id
	@NotNull
	private String storePwd; // Transaction key
	private String successUrl;
	private String cancelUrl;
	private String failureUrl;
	private String secretKey; // signature key

}
