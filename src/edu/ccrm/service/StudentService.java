package edu.ccrm.service;

import edu.ccrm.domain.Student;
import edu.ccrm.domain.Course;
import edu.ccrm.domain.semester;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StudentService implements Searchable<Student> {
    private Map<String, Student> students;

    public StudentService() {
        this.students = new HashMap<>();
    }

    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    public Student getStudent(String id) {
        return students.get(id);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }

    public void updateStudent(String id, String fullName, String email) {
        Student student = students.get(id);
        if (student != null) {
            student.setFullName(fullName);
            student.setEmail(email);
        }
    }

    public void deactivateStudent(String id) {
        Student student = students.get(id);
        if (student != null) {
            student.setActive(false);
        }
    }

    @Override
    public List<Student> search(Predicate<Student> predicate) {
        return students.values().stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    @Override
    public Student findById(String id) {
        return students.get(id);
    }

    public List<Student> getTopStudents(int count) {
        return students.values().stream()
                .filter(Student::isActive)
                .sorted((s1, s2) -> Double.compare(s2.calculateGPA(), s1.calculateGPA()))
                .limit(count)
                .collect(Collectors.toList());
    }
}