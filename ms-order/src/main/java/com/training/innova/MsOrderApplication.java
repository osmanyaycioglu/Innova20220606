package com.training.innova;

import com.training.common.error.RestErrorConfig;
import com.training.common.error.client.RestClientErrorConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.client.RestTemplate;

//@SpringBootApplication(scanBasePackages = {"com.training.innova", "com.training.common.error"})
@SpringBootApplication
@Import({RestErrorConfig.class, RestClientErrorConfig.class})
@EnableEurekaClient
@EnableFeignClients
@EnableRetry
public class MsOrderApplication {

//	@Bean
//	@LoadBalanced
//	public RestTemplate restTemplate(){
//		return new RestTemplate();
//	}

    public static void main(String[] args) {
        SpringApplication.run(MsOrderApplication.class,
                              args);
    }

}
