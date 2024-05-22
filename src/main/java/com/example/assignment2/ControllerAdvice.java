package com.example.assignment2;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.assignment2.customException.OperaationNotFoundException;
import com.example.assignment2.customException.ProgramNotFoundException;

@RestControllerAdvice
public class ControllerAdvice {

	@ExceptionHandler(ProgramNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ProgramNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(OperaationNotFoundException.class)
    public ResponseEntity<String> handleInvalidRequestException(OperaationNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
	
	
}
