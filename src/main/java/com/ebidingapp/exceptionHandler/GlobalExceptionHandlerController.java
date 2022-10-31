package com.ebidingapp.exceptionHandler;

import java.time.LocalDateTime;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlerController {


	@ExceptionHandler(BidEndDateException.class)
	public ResponseEntity<Object> bidEndDate (BidEndDateException ex, HttpServletRequest request){
		Error error=new Error();
		error.setMessage(ex.getMessage());
		error.setTimeStamp(new Date().getTime());
		error.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		return new ResponseEntity<>(error,null,HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	 public ResponseEntity<Object> handleExceptions( ResourceNotFoundException exception, HttpServletRequest request) {
        Error error = new Error();
        error.setTimeStamp(new Date().getTime());
        error.setMessage("Not found");
        ResponseEntity<Object> entity = new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
        return entity;
    }
}
