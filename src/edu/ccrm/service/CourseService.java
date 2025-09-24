package edu.ccrm.service;

import edu.ccrm.domain.Course;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CourseService implements Searchable<Course> {
    private Map<String, Course> courses;

    public CourseService() {
        this.courses = new HashMap<>();
    }

    public void addCourse(Course course) {
        courses.put(course.getCode(), course);
    }

    public Course getCourse(String code) {
        return courses.get(code);
    }

    public List<Course> getAllCourses() {
        return new ArrayList<>(courses.values());
    }

    public void updateCourse(String code, String title, int credits, String instructor) {
        Course course = courses.get(code);
        if (course != null) {
            Course updatedCourse = new Course.Builder(code, title)
                    .credits(credits)
                    .instructor(instructor)
                    .department(course.getDepartment())
                    .build();
            courses.put(code, updatedCourse);
        }
    }

    public void deactivateCourse(String code) {
        Course course = courses.get(code);
        if (course != null) {
            course.setActive(false);
        }
    }

    @Override
    public List<Course> search(Predicate<Course> predicate) {
        return courses.values().stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    @Override
    public Course findById(String id) {
        return courses.get(id);
    }

    public List<Course> getCoursesByInstructor(String instructor) {
        return search(course -> course.getInstructor().equalsIgnoreCase(instructor));
    }

    public List<Course> getCoursesByDepartment(String department) {
        return search(course -> course.getDepartment().equalsIgnoreCase(department));
    }
}