package com.payment.in.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.payment.in.entity.GatewayDetails;

@Repository
public interface GatewayDetailsRepository extends MongoRepository<GatewayDetails, String> {

	GatewayDetails getGatewayDetailsByGatewayName(String name);

}
