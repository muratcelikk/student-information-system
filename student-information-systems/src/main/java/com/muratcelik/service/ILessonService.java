package com.muratcelik.service;

import com.muratcelik.entity.Lesson;

import java.util.List;

public interface ILessonService {

    List<Lesson> getAllLesson();

    void addLesson(Lesson lesson);

    void updateLesson(Lesson lessonToUp);


}
