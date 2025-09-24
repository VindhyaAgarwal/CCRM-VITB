package edu.ccrm.domain;

public enum grade {
    S(10, "S"),
    A(9, "A"),
    B(8, "B"),
    C(7, "C"),
    D(6, "D"),
    F(0, "F");

    private final int Points;
    private final String desc;

    grade(int grade_points, String description) {
        this.Points = grade_points;
        this.desc = description;
    }

    public int getGradePoints() {
        return Points;
    }

    public String getDescription() {
        return desc;
    }

    public static grade fromMarks(double marks) {
        if (marks >= 90) return S;
        else if (marks >= 80) return A;
        else if (marks >= 70) return B;
        else if (marks >= 60) return C;
        else if (marks >= 50) return D;
        else return F;
    }
}