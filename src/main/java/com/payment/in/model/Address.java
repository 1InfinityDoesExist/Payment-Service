package com.payment.in.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
public class Address implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@NotNull
	@Size(max = 225)
	private String address1;
	@NotNull
	@Size(max = 225)
	private String address2;
	@NotNull
	@Size(max = 225)
	private String city;
	@NotNull
	@Size(max = 225)
	private String state;
	@NotNull
	@Size(max = 225)
	private String country;
	@NotNull
	@Size(max = 225)
	private String pin;
}
