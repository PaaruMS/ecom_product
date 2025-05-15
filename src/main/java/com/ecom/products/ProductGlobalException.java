package com.ecom.products;

import com.ecom.commonSrevice.utils.ErrorResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductGlobalException {

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<ErrorResponses> prodctNotFound(ItemNotFoundException ex){
        ErrorResponses errorResponse =new ErrorResponses("400",ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
