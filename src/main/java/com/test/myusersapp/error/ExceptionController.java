package com.test.myusersapp.error;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(new ErrorFormat("Field not well filled: " + ex.getFieldError()), headers, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = EmailRepeatedException.class)
    public ResponseEntity<ErrorFormat> emailRepeated() {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(new ErrorFormat("Email already on use"), headers, HttpStatus.BAD_REQUEST);
    }

}
