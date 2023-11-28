package com.educationalplatform.users;

import com.educationalplatform.courses.Course;

public class Student implements User {
    private String name;
    private int userId;

    public Student(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

    @Override
    public void enrollCourse(int courseId) {
        // Logic to enroll a student in a course
        System.out.println("Student " + name + " enrolled in course with ID: " + courseId);
    }

    @Override
    public void viewCourseProgress(int courseId) {
        // Logic to view student's progress in a course
        System.out.println("Viewing progress for student " + name + " in course with ID: " + courseId);
    }

    // Getters and setters for Student properties
    // ...
}
