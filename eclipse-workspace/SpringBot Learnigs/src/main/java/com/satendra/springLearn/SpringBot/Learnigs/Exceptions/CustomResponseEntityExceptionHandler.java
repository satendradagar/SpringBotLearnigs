package com.satendra.springLearn.SpringBot.Learnigs.Exceptions;

import com.satendra.springLearn.SpringBot.Learnigs.User.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public  final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
        ExceptionResponse excResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new  ResponseEntity(excResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public  final ResponseEntity<Object> handleUserNotFoundExceptions(UserNotFoundException ex, WebRequest request){
        ExceptionResponse excResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new  ResponseEntity(excResponse, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

//        ExceptionResponse excResponse = new ExceptionResponse(new Date(), ex.getMessage(), ex.getBindingResult().toString());
        ExceptionResponse excResponse = new ExceptionResponse(new Date(), "Validation Failed", ex.getBindingResult().toString());

        return  new ResponseEntity<>(excResponse, HttpStatus.BAD_REQUEST);
    }

}
