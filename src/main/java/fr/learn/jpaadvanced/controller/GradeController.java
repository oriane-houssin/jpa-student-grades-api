package fr.learn.jpaadvanced.controller;

import fr.learn.jpaadvanced.dto.GradeDto;
import fr.learn.jpaadvanced.entity.Grade;
import fr.learn.jpaadvanced.service.GradeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @PostMapping
    public ResponseEntity<Grade> createGrade(@Valid @RequestBody GradeDto gradeDto) {
        Grade grade = gradeService.createGrade(gradeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(grade);
    }

    @GetMapping("/student/{studentId}")
    public List<Grade> getGradesByStudentId(@PathVariable Long studentId) {
        return gradeService.getGradesByStudentId(studentId);
    }

    @GetMapping("/course/{courseId}")
    public List<Grade> getGradesByCourseId(@PathVariable Long courseId) {
        return gradeService.getGradesByCourseId(courseId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Grade> updateGrade(@PathVariable Long id, @Valid @RequestBody GradeDto gradeDto) {
        Grade grade = gradeService.updateGrade(id, gradeDto);
        return ResponseEntity.status(HttpStatus.OK).body(grade);
    }

    @DeleteMapping("{id}")
    public void deleteGrade(@PathVariable Long id) {
        gradeService.deleteGrade(id);
    }


}
