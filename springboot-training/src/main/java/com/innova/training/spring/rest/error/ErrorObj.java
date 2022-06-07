package com.innova.training.spring.rest.error;

import java.util.ArrayList;
import java.util.List;

public class ErrorObj {
    private List<ErrorObj> subErrors;
    private String desc;
    private int errorCode;
    private String origin;

    public ErrorObj addSubError(ErrorObj errorObj){
        if (subErrors == null){
            subErrors = new ArrayList<>();
        }
        subErrors.add(errorObj);
        return this;
    }

    public List<ErrorObj> getSubErrors() {
        return subErrors;
    }

    public ErrorObj setSubErrors(List<ErrorObj> subErrors) {
        this.subErrors = subErrors;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public ErrorObj setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public ErrorObj setErrorCode(int errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public String getOrigin() {
        return origin;
    }

    public ErrorObj setOrigin(String origin) {
        this.origin = origin;
        return this;
    }
}
