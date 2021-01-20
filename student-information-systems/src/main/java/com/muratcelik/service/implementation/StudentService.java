package com.muratcelik.service.implementation;

import com.muratcelik.entity.Student;
import com.muratcelik.repository.StudentRepo;
import com.muratcelik.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {

    private StudentRepo studentRepo;

    @Autowired // Constructor Injection
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    //Ögrenci listele
    @Override
    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    //Ögrenci Ekle
    @Override
    public void addStudent(Student student) {
        studentRepo.save(student);
    }

    //Ögrenci güncelle
    @Override
    public void updateStudent(Student studentToUp) {
        Student student = studentRepo.getOne(studentToUp.getId());
        student.setName(studentToUp.getName());
        student.setSurname(studentToUp.getSurname());
        student.setNumber(studentToUp.getNumber());
        student.setClassroom(studentToUp.getClassroom());
        student.setExplanation(studentToUp.getExplanation());
        student.setLesson(studentToUp.getLesson());
        studentRepo.save(student);
    }

    //Ögrenci sil
    @Override
    public void deleteStudentById(Integer id) {
        studentRepo.deleteById(id);
    }

    //Bir Ögrencinin id si ile derslerinin listelenmesi
    @Override
    public Optional<Student> getStudentById(Integer id) {
        return studentRepo.findById(id);
    }

    //Bir Ögrencinin adı ile derslerinin listelenmesi
    @Override
    public Student findByName(String student) {
        return studentRepo.findByName(student);
    }
}
