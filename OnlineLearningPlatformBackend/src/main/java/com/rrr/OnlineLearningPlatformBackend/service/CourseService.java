package com.rrr.OnlineLearningPlatformBackend.service;

import com.rrr.OnlineLearningPlatformBackend.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rrr.OnlineLearningPlatformBackend.repo.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Course updateCourse(Course updatedCourse) {
        return courseRepository.save(updatedCourse);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}