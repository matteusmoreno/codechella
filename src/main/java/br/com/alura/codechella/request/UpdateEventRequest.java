package br.com.alura.codechella.request;

import br.com.alura.codechella.constant.EventType;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UpdateEventRequest(
        @NotNull(message = "The id must be informed")
        Long id,
        EventType type,
        String name,
        LocalDate date,
        String description) {
}
