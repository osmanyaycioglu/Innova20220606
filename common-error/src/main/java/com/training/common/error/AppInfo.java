package com.training.common.error;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.info")
public class AppInfo {
    private String domain;
    private String subDomain;
    private String boundedContext;
    private String microservice;

    public String getDomain() {
        return domain;
    }

    public String getOrigin(){
        return domain + "/" + subDomain + "/" + boundedContext + "/" + microservice;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getSubDomain() {
        return subDomain;
    }

    public void setSubDomain(String subDomain) {
        this.subDomain = subDomain;
    }

    public String getBoundedContext() {
        return boundedContext;
    }

    public void setBoundedContext(String boundedContext) {
        this.boundedContext = boundedContext;
    }

    public String getMicroservice() {
        return microservice;
    }

    public void setMicroservice(String microservice) {
        this.microservice = microservice;
    }
}
