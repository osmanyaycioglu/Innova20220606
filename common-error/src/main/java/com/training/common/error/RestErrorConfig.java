package com.training.common.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestErrorConfig {

    @Bean
    public ErrorAdvice errorAdvice() {
        return new ErrorAdvice();
    }

    @Bean
    public AppInfo appInfo(){
        return new AppInfo();
    }

}
