package fr.learn.jpaadvanced.service;

import fr.learn.jpaadvanced.dto.CourseDto;
import fr.learn.jpaadvanced.entity.Course;
import fr.learn.jpaadvanced.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course createCourse(CourseDto courseDto) {
        Course course = new Course();
        course.setName(courseDto.getName());
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Course updateCourse(Long id, CourseDto courseDto) {
        Course course = getCourseById(id);
        course.setName(courseDto.getName());
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
