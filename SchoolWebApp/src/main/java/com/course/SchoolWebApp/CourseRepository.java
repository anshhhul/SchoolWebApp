package com.course.SchoolWebApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 *
 * Author: Anshul Alpesh Patel
 * Date: 13th December 2023
 * Program: SchoolWebApp (Java Final)
 * Repository Class: CourseRepository.java
 */

@Repository
public class CourseRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CourseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Course> courseRowMapper() {
        return (rs, rowNum) -> {
            Course course = new Course();
            course.setNumber(rs.getString("number"));
            course.setName(rs.getString("name"));
            course.setTerm(rs.getString("term"));
            return course;
        };
    }

    public List<Course> findAll() {
        String query = "SELECT * FROM course";
        return jdbcTemplate.query(query, courseRowMapper());
    }

    public Optional<Course> findById(String number) {
        String query = "SELECT * FROM course WHERE number = ?";
        List<Course> courses = jdbcTemplate.query(query, new Object[]{number}, courseRowMapper());
        return courses.stream().findFirst();
    }

    public Course save(Course course) {
        // Check if the course exists to determine insert or update
        if (existsById(course.getNumber())) {
            String updateQuery = "UPDATE course SET name = ?, term = ? WHERE number = ?";
            jdbcTemplate.update(updateQuery, course.getName(), course.getTerm(), course.getNumber());
        } else {
            String insertQuery = "INSERT INTO course (number, name, term) VALUES (?, ?, ?)";
            jdbcTemplate.update(insertQuery, course.getNumber(), course.getName(), course.getTerm());
        }
        return course;
    }

    public void deleteById(String number) {
        String query = "DELETE FROM course WHERE number = ?";
        jdbcTemplate.update(query, number);
    }

    public List<Course> findByName(String name) {
        String query = "SELECT * FROM course WHERE name = ?";
        return jdbcTemplate.query(query, new Object[]{name}, courseRowMapper());
    }

    public List<Course> findByTerm(String term) {
        String query = "SELECT * FROM course WHERE term = ?";
        return jdbcTemplate.query(query, new Object[]{term}, courseRowMapper());
    }

    public boolean existsById(String number) {
        String query = "SELECT COUNT(*) FROM course WHERE number = ?";
        Integer count = jdbcTemplate.queryForObject(query, new Object[]{number}, Integer.class);
        return count != null && count > 0;
    }
}
