package br.com.alura.codechella.request;

import br.com.alura.codechella.constant.EventType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateEventRequest(
        @NotNull(message = "Type is required")
        EventType type,
        @NotBlank(message = "Name is required")
        String name,
        String description) {
}
