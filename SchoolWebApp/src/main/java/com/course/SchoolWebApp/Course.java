package com.course.SchoolWebApp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 *
 * Author: Anshul Alpesh Patel
 * Date: 13th December 2023
 * Program: SchoolWebApp (Java Final)
 * Entity Class: course.java
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course")
public class Course {

    @Id
    @Column(name = "number")
    private String number;

    @Column(name = "name")
    private String name;

    @Column(name = "term")
    private String term;
}
