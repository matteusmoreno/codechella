package br.com.alura.codechella.controller;

import br.com.alura.codechella.entity.Event;
import br.com.alura.codechella.request.CreateEventRequest;
import br.com.alura.codechella.request.UpdateEventRequest;
import br.com.alura.codechella.response.EventDetailsResponse;
import br.com.alura.codechella.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import java.time.Duration;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;
    private final Sinks.Many<EventDetailsResponse> sink;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
        this.sink = Sinks.many().multicast().onBackpressureBuffer();
    }

    @PostMapping
    public Mono<EventDetailsResponse> create(@RequestBody CreateEventRequest request) {
        return eventService.createEvent(request).doOnSuccess(sink::tryEmitNext);
    }

    @GetMapping
    public Flux<Event> findAll() {
        return eventService.findAllEvents();
    }

    @GetMapping("/{id}")
    public Mono<Event> findById(@PathVariable Long id) {
        return eventService.findEventById(id);
    }

    @PutMapping
    public Mono<Event> update(@RequestBody UpdateEventRequest request) {
        return eventService.updateEvent(request);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id) {
        return eventService.deleteEvent(id);
    }

    @GetMapping(value = "/type/{type}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<EventDetailsResponse> findByType(@PathVariable String type) {
        return Flux.merge(eventService.findEventByType(type), sink.asFlux())
                .delayElements(Duration.ofSeconds(4));
    }

}
