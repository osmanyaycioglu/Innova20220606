package com.innova.training.spring.rest;

public class HelloResponse {
    private String desc;
    private Integer status;

    public static HelloResponse create(){
        return new HelloResponse();
    }

    public String getDesc() {
        return desc;
    }

    public HelloResponse setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public HelloResponse setStatus(Integer status) {
        this.status = status;
        return this;
    }
}
