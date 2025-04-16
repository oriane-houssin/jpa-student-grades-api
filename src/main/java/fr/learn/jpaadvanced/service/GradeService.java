package fr.learn.jpaadvanced.service;

import fr.learn.jpaadvanced.dto.GradeDto;
import fr.learn.jpaadvanced.entity.Course;
import fr.learn.jpaadvanced.entity.Grade;
import fr.learn.jpaadvanced.entity.Student;
import fr.learn.jpaadvanced.repository.CourseRepository;
import fr.learn.jpaadvanced.repository.GradeRepository;
import fr.learn.jpaadvanced.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Grade createGrade(GradeDto gradeDto) {
        Student student = studentRepository.findById(gradeDto.getStudentId()).orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(gradeDto.getCourseId()).orElseThrow(() -> new RuntimeException("Course not found"));
        Grade grade = new Grade();
        grade.setValue(gradeDto.getValue());
        grade.setStudent(student);
        grade.setCourse(course);
        return gradeRepository.save(grade);
    }

    public List<Grade> getGradesByStudentId(Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }

    public List<Grade> getGradesByCourseId(Long courseId) {
        return gradeRepository.findByCourseId(courseId);
    }

    public Grade updateGrade(Long gradeId, GradeDto gradeDto) {
        Grade grade = gradeRepository.findById(gradeId).orElseThrow(() -> new RuntimeException("Grade not found"));
        Student student = studentRepository.findById(gradeDto.getStudentId()).orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(gradeDto.getCourseId()).orElseThrow(() -> new RuntimeException("Course not found"));
        grade.setValue(gradeDto.getValue());
        grade.setStudent(student);
        grade.setCourse(course);
        return gradeRepository.save(grade);
    }

    public void deleteGrade(Long gradeId) {
        gradeRepository.deleteById(gradeId);
    }
}
