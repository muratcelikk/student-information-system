package com.muratcelik.service;

import com.muratcelik.entity.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {

    List<Student> getAllStudent();

    void addStudent(Student student);

    void deleteStudentById(Integer id);

    void updateStudent(Student studentToUp);

    Optional<Student> getStudentById(Integer id);

    Student findByName(String studentName);
}
