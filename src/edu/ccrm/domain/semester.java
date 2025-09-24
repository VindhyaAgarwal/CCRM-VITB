package edu.ccrm.domain;

public enum semester {
    FALL("Fall Semester", "AUG-DEC"),
    WINTER("Winter Semester", "JAN-APR"),
    INTERIM("Interim Semester", "MAY-JUN"),
    SUMMER("Summer Semester", "JUL");

    private final String description;
    private final String duration;

    semester(String description, String duration) {
        this.description = description;
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public String getDuration() {
        return duration;
    }
}