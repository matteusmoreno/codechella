package br.com.alura.codechella.entity;

import br.com.alura.codechella.constant.EventType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table("events")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
public class Event {

    @Id
    private Long id;
    private EventType type;
    private String name;
    private LocalDate date;
    private String description;
}
