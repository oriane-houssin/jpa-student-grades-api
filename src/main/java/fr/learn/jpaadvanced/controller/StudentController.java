package fr.learn.jpaadvanced.controller;

import fr.learn.jpaadvanced.dto.StudentDto;
import fr.learn.jpaadvanced.entity.Student;
import fr.learn.jpaadvanced.repository.StudentRepository;
import fr.learn.jpaadvanced.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody @Valid StudentDto studentDto) {
        Student student = studentService.createStudent(studentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody @Valid StudentDto studentDto) {
        Student student = studentService.updateStudent(id, studentDto);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

}
