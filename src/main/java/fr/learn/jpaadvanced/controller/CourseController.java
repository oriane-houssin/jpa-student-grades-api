package fr.learn.jpaadvanced.controller;

import fr.learn.jpaadvanced.entity.Course;
import fr.learn.jpaadvanced.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }
    @GetMapping
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
