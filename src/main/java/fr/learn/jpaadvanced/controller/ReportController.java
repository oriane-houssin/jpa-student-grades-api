package fr.learn.jpaadvanced.controller;

import fr.learn.jpaadvanced.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("course/{courseId}")
    public ResponseEntity<Map<String, Object>> getCourseReports(@PathVariable Long courseId) {
        float moyenne = reportService.getAverageGradeByCourse(courseId);
        Map<String, Object> response = new HashMap<>();
        response.put("courseId", courseId);
        response.put("moyenne", moyenne);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<Map<String, Object>> getStudentReports(@PathVariable Long studentId) {
        float moyenne = reportService.getAverageGradeByStudent(studentId);
        Map<String, Object> response = new HashMap<>();
        response.put("studentId", studentId);
        response.put("moyenne", moyenne);
        return ResponseEntity.ok(response);
    }
}
