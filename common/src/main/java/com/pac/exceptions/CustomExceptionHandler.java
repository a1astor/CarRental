package com.pac.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchCarException.class)
    protected ResponseEntity<DaoException> handleNoSuchCarException() {
        return new ResponseEntity<>(new DaoException("There is no such car"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchAddressException.class)
    protected ResponseEntity<DaoException> handleNoSuchAddressException() {
        return new ResponseEntity<>(new DaoException("There is no such address"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CanNotCreateContractException.class)
    protected ResponseEntity<DaoException> handleCanNotCreateContractException() {
        return new ResponseEntity<>(new DaoException("Can't create contract with given data"), HttpStatus.BAD_REQUEST);
    }

    @Data
    @AllArgsConstructor
    private static class DaoException {
        private String message;
    }
}