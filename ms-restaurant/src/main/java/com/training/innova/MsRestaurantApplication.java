package com.training.innova;

import com.training.common.error.RestErrorConfig;
import com.training.common.error.client.RestClientErrorConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableEurekaClient
@Import({RestErrorConfig.class, RestClientErrorConfig.class})
public class MsRestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsRestaurantApplication.class, args);
	}

}
