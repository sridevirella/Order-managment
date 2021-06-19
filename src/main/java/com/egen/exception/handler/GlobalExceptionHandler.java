package com.egen.exception.handler;

import com.egen.exception.BadRequestException;
import com.egen.exception.InternalServerException;
import com.egen.exception.OrderServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="BadRequest occured")
    @ExceptionHandler(BadRequestException.class)
    public void handleBadRequestException(){
       // logger.error("BadRequestException handler executed");
        System.out.println("BadRequestException handler executed");
    }

    @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR, reason="Internal Server Error occured")
    @ExceptionHandler(InternalServerException.class)
    public void handleInternalServerErrorException(){
        // logger.error("InternalServerErrorException handler executed");
        System.out.println("InternalServerErrorException handler executed");
    }

    @ResponseStatus
    @ExceptionHandler(OrderServiceException.class)
    public void handleOrderServiceException(){
        // logger.error("OrderService exception handler executed");
        System.out.println("OrderService exception handler executed");
    }
}