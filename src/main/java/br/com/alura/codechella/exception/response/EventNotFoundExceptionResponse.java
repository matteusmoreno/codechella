package br.com.alura.codechella.exception.response;

import br.com.alura.codechella.exception.EventNotFoundException;
import org.springframework.http.HttpStatus;

public record EventNotFoundExceptionResponse(
        HttpStatus httpStatus,
        String eventNotFound) {
    public EventNotFoundExceptionResponse(EventNotFoundException ex) {
        this(ex.getHttpStatus(), ex.getEventNotFound());
    }
}
