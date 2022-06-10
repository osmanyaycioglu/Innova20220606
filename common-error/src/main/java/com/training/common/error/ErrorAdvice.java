package com.training.common.error;

import com.training.common.error.client.RestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

@RestControllerAdvice
public class ErrorAdvice {

    private static Logger logger = LoggerFactory.getLogger(ErrorAdvice.class);

    @Autowired
    private AppInfo appInfo;

    private ErrorObj baseErrorObj(){
        return new ErrorObj().setOrigin(appInfo.getOrigin());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(IllegalArgumentException exp) {
        return baseErrorObj().setDesc(exp.getMessage())
                             .setErrorCode(10001);
    }

    @ExceptionHandler(RestException.class)
    public ResponseEntity<ErrorObj> handleException(RestException exp) {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                             .body(baseErrorObj().setDesc("Error while calling another microservice")
                                                 .setErrorCode(1400)
                                                 .addSubError(exp.getErrorObj()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(MethodArgumentNotValidException exp) {
        ErrorObj root = baseErrorObj().setDesc("validasyon problemi")
                                      .setErrorCode(12000);
        List<ObjectError> allErrors = exp.getAllErrors();
        for (ObjectError objErr : allErrors) {
            root.addSubError(baseErrorObj().setDesc(objErr.toString())
                                           .setErrorCode(12000));
        }
        return root;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(ConstraintViolationException exp) {
        ErrorObj root = baseErrorObj().setDesc("Db validasyon problemi")
                                      .setErrorCode(12001);
        Set<ConstraintViolation<?>> constraintViolations = exp.getConstraintViolations();
        for (ConstraintViolation<?> objErr : constraintViolations) {
            root.addSubError(baseErrorObj().setDesc(objErr.toString())
                                           .setErrorCode(12001));
        }
        return root;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorObj handleException(Exception exp) {
        logger.error(exp.getMessage(),
                     exp);
        return baseErrorObj().setDesc(exp.getMessage())
                             .setErrorCode(15000);
    }

}

