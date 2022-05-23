package Konferencja.services;

import Konferencja.db_classes.Lecture;
import Konferencja.repositories.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureService {

    final private LectureRepository lectureRepository;
    @Autowired
    public LectureService(LectureRepository lectureRepository){
        this.lectureRepository = lectureRepository;
    }

    public List<Lecture> getLecture(){
        return lectureRepository.findAll();
    }

    public void addNewLecture(Lecture lecture)
    {
        lectureRepository.save(lecture);
    }


    public void deleteLecture(Long lectureID) {
        boolean exists = lectureRepository.existsById(lectureID);
        if(!exists)
        {
            throw new IllegalStateException("Lecture with id " + lectureID + " does not exists!");
        }
        else
        {
            lectureRepository.deleteById(lectureID);
        }
    }
}
