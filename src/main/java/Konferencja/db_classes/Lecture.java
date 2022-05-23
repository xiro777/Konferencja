package Konferencja.db_classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lecture")
public class Lecture {
    @Id
    @SequenceGenerator(name = "lecture_name_generator", sequenceName = "lecture_name_generator", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lecture_name_generator")
    private long id;
    @Column(name = "lecture_name",nullable = false)
    private String lectureName;

    @Column(name = "lecture_description",nullable = false)
    private String lectureDescription;

    @Column(name = "lecture_time",nullable = false)
    private Time lectureTime;


}
