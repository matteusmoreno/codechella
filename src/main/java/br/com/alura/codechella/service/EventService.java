package br.com.alura.codechella.service;

import br.com.alura.codechella.constant.EventType;
import br.com.alura.codechella.entity.Event;
import br.com.alura.codechella.exception.EventNotFoundException;
import br.com.alura.codechella.repository.EventRepository;
import br.com.alura.codechella.request.CreateEventRequest;
import br.com.alura.codechella.request.UpdateEventRequest;
import br.com.alura.codechella.response.EventDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Transactional
    public Mono<EventDetailsResponse> createEvent(CreateEventRequest createEventRequest) {
        Event event = Event.builder()
                .type(createEventRequest.type())
                .name(createEventRequest.name())
                .description(createEventRequest.description())
                .build();

        return eventRepository.save(event).map(EventDetailsResponse::new);
    }

    public Flux<Event> findAllEvents() {
        return eventRepository.findAll();
    }

    public Mono<Event> findEventById(Long id) {
        return eventRepository.findById(id).switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found")));
    }

    //UPDATE EVENT
    @Transactional
    public Mono<Event> updateEvent(UpdateEventRequest request) {
        return eventRepository.findById(request.id())
                .switchIfEmpty(Mono.error(new EventNotFoundException()))
                .map(event -> {
                    if (request.type() != null) event.setType(request.type());
                    if (request.name() != null) event.setName(request.name());
                    if (request.date() != null) event.setDate(request.date());
                    if (request.description() != null) event.setDescription(request.description());
                    return event;
                })
                .flatMap(eventRepository::save);
    }

    @Transactional
    public Mono<Void> deleteEvent(Long id) {
        return eventRepository.deleteById(id);
    }

    public Flux<EventDetailsResponse> findEventByType(String type) {
        try {
            return eventRepository.findByType(EventType.valueOf(type.toUpperCase()))
                    .map(EventDetailsResponse::new)
                    .switchIfEmpty(Mono.error(new EventNotFoundException()));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        }
    }

}
