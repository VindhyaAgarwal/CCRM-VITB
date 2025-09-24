package edu.ccrm.service;

import edu.ccrm.domain.Student;
import edu.ccrm.domain.Enrollment;
import edu.ccrm.domain.grade;
import java.util.List;

public class TranscriptService {
    private EnrollmentService enrollmentService;
    
    public TranscriptService(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }
    
    public void generateTranscript(String studentId) {
        List<Enrollment> enrollments = enrollmentService.getEnrollmentsByStudent(studentId);
        System.out.println("\n=== TRANSCRIPT ===");
        System.out.println("Student ID: " + studentId);
        System.out.println("Courses Completed: " + enrollments.size());
        
        double totalPoints = 0;
        int totalCredits = 0;
        
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getGrade() != null) {
                System.out.printf("Course: %s, Grade: %s, Marks: %s%n", 
                    enrollment.getCourse().getCode(), 
                    enrollment.getGrade(), 
                    enrollment.getMarks());
            }
        }
        
        double gpa = calculateGPA(studentId);
        System.out.printf("GPA: %.2f%n", gpa);
    }
    
    public double calculateGPA(String studentId) {
        List<Enrollment> enrollments = enrollmentService.getEnrollmentsByStudent(studentId);
        
        if (enrollments.isEmpty()) {
            return 0.0;
        }

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
}