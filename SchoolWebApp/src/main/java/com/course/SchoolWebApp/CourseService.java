package com.course.SchoolWebApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * Author: Anshul Alpesh Patel
 * Date: 13th December 2023
 * Program: SchoolWebApp (Java Final)
 * Service Class: CourseService.java
 */

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    // Constructor-based dependency injection
    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // Get all courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Get a single course by course number
    public Optional<Course> getCourseByNumber(String number) {
        return courseRepository.findById(number);
    }

    // Add a new course
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    // Update an existing course
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    // Delete a course by course number
    public void deleteCourse(String number) {
        courseRepository.deleteById(number);
    }

    // Find courses by name
    public List<Course> findCoursesByName(String name) {
        return courseRepository.findByName(name);
    }

    // Find courses by term
    public List<Course> findCoursesByTerm(String term) {
        return courseRepository.findByTerm(term);
    }

    // Check if a course exists by number
    public boolean existsCourse(String number) {
        return courseRepository.existsById(number);
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

}
