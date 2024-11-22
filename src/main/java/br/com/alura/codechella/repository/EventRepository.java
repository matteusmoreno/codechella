package br.com.alura.codechella.repository;

import br.com.alura.codechella.constant.EventType;
import br.com.alura.codechella.entity.Event;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface EventRepository extends ReactiveCrudRepository<Event, Long> {
    Flux<Event> findByType(EventType type);
}
