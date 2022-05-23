package Konferencja.repositories;

import Konferencja.db_classes.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LectureRepository extends JpaRepository<Lecture,Long> {
    Optional<Lecture> findLectureByLectureName(String lectureName);
}
