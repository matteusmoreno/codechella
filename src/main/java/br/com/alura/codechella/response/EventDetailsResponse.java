package br.com.alura.codechella.response;

import br.com.alura.codechella.constant.EventType;
import br.com.alura.codechella.entity.Event;

import java.time.LocalDate;

public record EventDetailsResponse(
        Long id,
        EventType type,
        String name,
        LocalDate date,
        String description) {

    public EventDetailsResponse(Event event) {
        this(event.getId(), event.getType(), event.getName(), event.getDate(), event.getDescription());
    }
}
