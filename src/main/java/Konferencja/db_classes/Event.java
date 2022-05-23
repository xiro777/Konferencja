package Konferencja.db_classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "event")
public class Event {
    @Id
    @SequenceGenerator(name = "event_name_generator", sequenceName = "event_name_generator", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_name_generator")
    private long id;
    @Column(name = "event_name",nullable = false)
    private String eventName;
    @Column(name = "event_date",nullable = false)
    private Date eventDate;



}
