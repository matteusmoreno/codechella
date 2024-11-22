package br.com.alura.codechella.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<String> handleResponseStatusException(ResponseStatusException ex) {
        return ResponseEntity.status(ex.getStatusCode()).body(ex.getReason());
    }

    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<String> handleEventNotFoundException(EventNotFoundException ex) {
        return ResponseEntity.status(ex.getHttpStatus()).body(ex.getEventNotFound());
    }
}
