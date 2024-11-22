package br.com.alura.codechella.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class EventNotFoundException extends RuntimeException {

    private HttpStatus httpStatus = HttpStatus.NOT_FOUND;
    private String eventNotFound = "Event not found";
}

