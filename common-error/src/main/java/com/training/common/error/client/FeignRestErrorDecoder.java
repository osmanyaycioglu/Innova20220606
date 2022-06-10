package com.training.common.error.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.common.error.ErrorObj;
import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;

public class FeignRestErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey,
                            Response response) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ErrorObj errorObj = objectMapper.readValue(response.body()
                                                               .asInputStream(),
                                                       ErrorObj.class);
            return new RestException(errorObj);
        } catch (Exception exp){
            exp.printStackTrace();
        }
        return new RestException(null);
    }

}
