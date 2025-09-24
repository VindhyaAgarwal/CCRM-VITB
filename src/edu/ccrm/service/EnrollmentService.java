package edu.ccrm.service;

import edu.ccrm.domain.Enrollment;
import edu.ccrm.domain.Student;
import edu.ccrm.domain.Course;
import edu.ccrm.domain.grade;
import edu.ccrm.domain.semester;
import java.util.*;

public class EnrollmentService {
    private Map<String, Enrollment> enrollments;
    private StudentService studentService;
    private CourseService courseService;
    
    public EnrollmentService(StudentService studentService, CourseService courseService) {
        this.enrollments = new HashMap<>();
        this.studentService = studentService;
        this.courseService = courseService;
    }
    
    public boolean enrollStudent(String studentId, String courseCode, semester semester, int academicYear) {
        Student student = studentService.getStudent(studentId);
        Course course = courseService.getCourse(courseCode);
        
        if (student == null || course == null) {
            return false;
        }
        
        String enrollmentId = studentId + "-" + courseCode + "-" + semester + "-" + academicYear;
        
        // Check for duplicate enrollment
        if (enrollments.containsKey(enrollmentId)) {
            return false;
        }
        
        Enrollment enrollment = new Enrollment(student, course, semester, academicYear);
        enrollments.put(enrollmentId, enrollment);
        return true;
    }
    
    public boolean recordGrade(String studentId, String courseCode, semester semester, int academicYear, double marks) {
        String enrollmentId = studentId + "-" + courseCode + "-" + semester + "-" + academicYear;
        Enrollment enrollment = enrollments.get(enrollmentId);
        if (enrollment != null) {
            enrollment.recordMarks(marks);
            return true;
        }
        return false;
    }
    
    public List<Enrollment> getEnrollmentsByStudent(String studentId) {
        List<Enrollment> result = new ArrayList<>();
        for (Enrollment enrollment : enrollments.values()) {
            if (enrollment.getStudent().getId().equals(studentId)) {
                result.add(enrollment);
            }
        }
        return result;
    }
    
    public Enrollment getEnrollment(String enrollmentId) {
        return enrollments.get(enrollmentId);
    }
    
    public List<Enrollment> getAllEnrollments() {
        return new ArrayList<>(enrollments.values());
    }
}