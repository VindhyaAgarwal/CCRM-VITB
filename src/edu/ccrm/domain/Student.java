package edu.ccrm.domain;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private String regNo;
    private List<Enrollment> enrollments;

    public Student(String id, String regNo, String fullName, String email) {
        super(id, fullName, email);
        this.regNo = regNo;
        this.enrollments = new ArrayList<>();
    }

    public String getRegNo() { return regNo; }
    public void setRegNo(String regNo) { this.regNo = regNo; }

    public List<Enrollment> getEnrollments() { return enrollments; }

    public void enrollInCourse(Course course, semester semester, int academicYear) {
        Enrollment enrollment = new Enrollment(this, course, semester, academicYear);
        enrollments.add(enrollment);
    }

    public double calculateGPA() {
        if (enrollments.isEmpty()) return 0.0;

        double totalGradePoints = 0;
        int totalCredits = 0;

        for (Enrollment enrollment : enrollments) {
            if (enrollment.getGrade() != null) {
                totalGradePoints += enrollment.getGrade().getGradePoints() * enrollment.getCourse().getCredits();
                totalCredits += enrollment.getCourse().getCredits();
            }
        }

        return totalCredits > 0 ? totalGradePoints / totalCredits : 0.0;
    }

    @Override
    public String getDisplayInfo() {
        return String.format("Student: %s (Reg: %s) - GPA: %.2f", fullName, regNo, calculateGPA());
    }

    @Override
    public String toString() {
        return String.format("Student[ID: %s, RegNo: %s, Name: %s, Email: %s, GPA: %.2f]", 
                           id, regNo, fullName, email, calculateGPA());
    }
}