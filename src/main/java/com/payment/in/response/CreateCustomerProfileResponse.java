package com.payment.in.response;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.payment.in.model.ADNMessages;

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
public class CreateCustomerProfileResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private String customerProfileId;
	private List<String> customerPaymentProfileIdList;
	private List<String> customerShippingAddressIdList;
	private List<String> validationDirectResponseList;
	private ADNMessages messages;
}
