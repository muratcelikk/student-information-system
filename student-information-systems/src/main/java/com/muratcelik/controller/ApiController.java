package com.muratcelik.controller;

import com.muratcelik.entity.Lesson;
import com.muratcelik.entity.Student;
import com.muratcelik.service.ILessonService;
import com.muratcelik.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiController {


    private ILessonService lessonService;
    private IStudentService studentService;

    @Autowired
    public ApiController(ILessonService lessonService, IStudentService studentService) {
        this.lessonService = lessonService;
        this.studentService = studentService;
    }

    //GetAll
    @GetMapping(value = "/get/getAllStudent")
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping(value = "/get/getAllLesson")
    public List<Lesson> getAllLesson() {
        return lessonService.getAllLesson();
    }

    //Delete
    @PostMapping(value = "/admin/deleteStudent")
    public ResponseEntity<String> deleteStudent(@RequestBody Student student) {
        studentService.deleteStudentById(student.getId());
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }

    //Add
    @PostMapping(value = "/admin/addStudent")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }

    @PostMapping(value = "/admin/addLesson")
    public ResponseEntity<String> addLesson(@RequestBody Lesson lesson) {
        lessonService.addLesson(lesson);
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }

    //Update
    @PostMapping(value = "/admin/updateStudent")
    public ResponseEntity<String> updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }

    @PostMapping(value = "/admin/updateLesson")
    public ResponseEntity<String> updateLesson(@RequestBody Lesson lesson) {
        lessonService.updateLesson(lesson);
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }

    //GetById
    @GetMapping(value = "/get/getStudentById/{id}")
    public Optional<Student> getStudentById(@PathVariable("id") Integer id) {
        return studentService.getStudentById(id);
    }

    //FindBy
    @GetMapping(value = "/get/findByStudentName/{studentName}")
    public Student findByStudentName(@PathVariable("studentName") String studentName) {
        return studentService.findByName(studentName);
    }
}

