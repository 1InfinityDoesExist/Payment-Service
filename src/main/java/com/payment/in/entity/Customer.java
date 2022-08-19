package com.payment.in.entity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.payment.in.model.Address;

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
@Document(collection = "customers")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@Size(max = 225)
	private String emailId;
	@Size(max = 225)
	private String mobile;
	@NotNull
	@Size(max = 225)
	private String name;
	@Size(max = 225)
	private String phone;
	/* this field is used in Authorize.net payment gateway */
	private String profileId;
	private Address address;
	@NotNull
	@Size(max = 225)
	private String pin;
	private String stripeId;
	private boolean isActive;
	private boolean hasPrimaryCard;

}
