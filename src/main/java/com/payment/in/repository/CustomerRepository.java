package com.payment.in.repository;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.payment.in.entity.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

	Customer findCustomerByEmailId(@NotNull String emailId);

}
