package Konferencja.repositories;

import Konferencja.db_classes.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository implements JpaRepository<Lecture,Long> {
}
