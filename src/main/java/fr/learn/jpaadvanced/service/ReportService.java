package fr.learn.jpaadvanced.service;

import fr.learn.jpaadvanced.entity.Grade;
import fr.learn.jpaadvanced.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private GradeRepository gradeRepository;

    public Float getAverageGradeByCourse(Long courseId) {
        List<Grade> grades = gradeRepository.findByCourseId(courseId);
        if (grades.isEmpty()) {
            throw new RuntimeException("aucunne note");
        }
        return (float) grades.stream().mapToDouble(g->g.getValue()).average().orElse(0.0);
    }

    public Float getAverageGradeByStudent(Long studentId) {
        List<Grade> grades = gradeRepository.findByStudentId(studentId);
        if (grades.isEmpty()) {
            throw new RuntimeException("aucunne note");
        }
        return (float) grades.stream().mapToDouble(g->g.getValue()).average().orElse(0.0);
    }
}
