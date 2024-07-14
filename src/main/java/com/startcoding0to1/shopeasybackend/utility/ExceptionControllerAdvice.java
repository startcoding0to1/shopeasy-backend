package com.startcoding0to1.shopeasybackend.utility;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.startcoding0to1.shopeasybackend.constants.ShopEasyConstants;
import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(ShopEasyException.class)
    public ResponseEntity<ErrorInfo> shopEasyException(ShopEasyException shopEasyException){
        ErrorInfo errorInfo=new ErrorInfo();
        errorInfo.setErrorMessage(shopEasyException.getMessage());
        errorInfo.setErrorCode(shopEasyException.getStatus().value());
        errorInfo.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<ErrorInfo>(errorInfo,shopEasyException.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorInfo> exceptionHandler(Exception exception){
        ErrorInfo errorInfo=new ErrorInfo();
        if(exception.getMessage().contains("No static resource")){
            errorInfo.setErrorMessage(ShopEasyConstants.CHECK_URL);
            errorInfo.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            errorInfo.setTimestamp(LocalDateTime.now());
        }else {
            errorInfo.setErrorMessage(exception.getMessage());
            errorInfo.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            errorInfo.setTimestamp(LocalDateTime.now());
        }
        return new ResponseEntity<ErrorInfo>(errorInfo,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
