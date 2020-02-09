package com.jaydot2.rest.cloud.contract.restcloudconsumercontract;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableFeignClients
public class RestCloudConsumerContractApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestCloudConsumerContractApplication.class, args);
	}

}
