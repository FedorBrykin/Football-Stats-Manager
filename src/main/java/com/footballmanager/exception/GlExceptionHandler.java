package com.footballmanager.exception;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice // обработчик исключений
public class GlExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException exep, WebRequest req) {
        ErrorDescr errorDetails = new ErrorDescr(
                new Date(),
                exep.getMessage(),
                req.getDescription(false)
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException excep, WebRequest req) {
        String errorMessage = "Validation error: ";
        for (FieldError error : excep.getBindingResult().getFieldErrors()) {
            errorMessage += error.getDefaultMessage() + "; ";
        }

        ErrorDescr errorDetails = new ErrorDescr(
                new Date(),
                errorMessage,
                req.getDescription(false)
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST); // 400
    }
}
