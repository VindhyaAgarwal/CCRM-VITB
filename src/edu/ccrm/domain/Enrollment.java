package edu.ccrm.domain;

import java.time.LocalDateTime;

public class Enrollment {
    private Student student;
    private Course course;
    private semester semester;
    private int academicYear;
    private Double marks;
    private grade grade;
    private LocalDateTime enrolledAt;

    public Enrollment(Student student, Course course, semester semester, int academicYear) {
        this.student = student;
        this.course = course;
        this.semester = semester;
        this.academicYear = academicYear;
        this.enrolledAt = LocalDateTime.now();
    }

    public void recordMarks(double marks) {
        this.marks = marks;
        this.grade = grade.fromMarks(marks);
    }
    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
    public semester getSemester() { return semester; }
    public int getAcademicYear() { return academicYear; }
    public Double getMarks() { return marks; }
    public grade getGrade() { return grade; }
    public LocalDateTime getEnrolledAt() { return enrolledAt; }

    @Override
    public String toString() {
        return String.format("Enrollment[Student: %s, Course: %s, Semester: %s, Year: %d, Marks: %s, Grade: %s]", 
                           student.getRegNo(), course.getCode(), semester, academicYear, 
                           marks != null ? marks : "Not Graded", grade != null ? grade : "N/A");
    }
}