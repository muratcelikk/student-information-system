package com.muratcelik.service.implementation;

import com.muratcelik.entity.Lesson;
import com.muratcelik.repository.LessonRepo;
import com.muratcelik.repository.StudentRepo;
import com.muratcelik.service.ILessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonService implements ILessonService {

    private LessonRepo lessonRepo;
    private StudentRepo studentRepo;

    @Autowired // Constructor Injection
    public LessonService(LessonRepo lessonRepo, StudentRepo studentRepo) {
        this.lessonRepo = lessonRepo;
        this.studentRepo = studentRepo;
    }

    //Ders Listele
    @Override
    public List<Lesson> getAllLesson() {
        return lessonRepo.findAll();
    }

    //Ders Ekle
    @Override
    public void addLesson(Lesson lesson) {
        lessonRepo.save(lesson);
    }

    //Ders güncelle
    @Override
    public void updateLesson(Lesson lessonToUp) {
        Lesson lesson = lessonRepo.getOne(lessonToUp.getId());
        lesson.setLessonCode(lessonToUp.getLessonCode());
        lesson.setLessonName(lessonToUp.getLessonName());
        lesson.setExplanation(lessonToUp.getExplanation());
        lesson.setStudent(lessonToUp.getStudent());
        lessonRepo.save(lesson);
    }
}
