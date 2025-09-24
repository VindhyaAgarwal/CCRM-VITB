package edu.ccrm.util;

public class Validator {
    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
    
    public static boolean isValidStudentId(String id) {
        return id != null && id.matches("^S\\d{3}$");
    }
    
    public static boolean isValidCourseCode(String code) {
        return code != null && code.matches("^[A-Z]{2,4}\\d{3}$");
    }
}