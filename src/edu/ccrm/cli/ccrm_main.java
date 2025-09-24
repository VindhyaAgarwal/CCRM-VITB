package edu.ccrm.cli;

import edu.ccrm.config.AppConfig;
import edu.ccrm.domain.*;
import edu.ccrm.service.StudentService;
import edu.ccrm.service.CourseService;
import edu.ccrm.io.FileService;
import edu.ccrm.exceptions.DuplicateEnrollmentException;
import edu.ccrm.exceptions.MaxCreditLimitExceededException;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ccrm_main {
    private StudentService studentService;
    private CourseService courseService;
    private FileService fileService;
    private Scanner scanner;

    public ccrm_main() {
        this.studentService = new StudentService();
        this.courseService = new CourseService();
        this.fileService = new FileService();
        this.scanner = new Scanner(System.in);
        initializeSampleData();
    }

    private void initializeSampleData() {
        Course java = new Course.Builder("CSE3001", "Programming in Java")
                .credits(4).instructor("Kamlesh Chandravansshi").department("Computer Science").build();
        Course db = new Course.Builder("CSE2002", "Database Management Systems")
                .credits(3).instructor("Rizwan Ur Rehman").department("Computer Science").build();
        Course math = new Course.Builder("MATH1001", "Applied Linear Algebra")
                .credits(4).instructor("Dondu Harish Babu").department("Mathematics").build();

        courseService.addCourse(java);
        courseService.addCourse(db);
        courseService.addCourse(math);

        // Sample students
        Student student1 = new Student("S001", "2024BCE11058", "Vindhya Agarwal", "vindhya.24bce11058@vitbhopal.ac.in");
        Student student2 = new Student("S002", "2024BCE10972", "Parul Thakur", "parul.24bce10972@vitbhopal.ac.in");

        studentService.addStudent(student1);
        studentService.addStudent(student2);

        // Sample enrollments
        student1.enrollInCourse(java, semester.FALL, 2025);
        student1.enrollInCourse(db, semester.FALL, 2025);
        student2.enrollInCourse(math, semester.WINTER, 2025);
    }

    public void start() {
        System.out.println("Welcome to VIT Bhopal Campus Course & Records Manager (CCRM)");
        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1 -> manageStudents();
                case 2 -> manageCourses();
                case 3 -> manageEnrollments();
                case 4 -> manageGrades();
                case 5 -> importExportData();
                case 6 -> backupOperations();
                case 7 -> generateReports();
                case 8 -> displayJavaInfo();
                case 0 -> {
                    running = false;
                    System.out.println("Thank you for using CCRM");
                }
                default -> System.out.println("Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }

    private void displayMainMenu() {
        System.out.println("1. Student Management");
        System.out.println("2. Course Management");
        System.out.println("3. Enrollment Management");
        System.out.println("4. Grade Management");
        System.out.println("5. Import/Export Data");
        System.out.println("6. Backup Operations");
        System.out.println("7. Reports");
        System.out.println("8. Java Platform Info");
        System.out.println("0. Exit");
    }

    private void manageStudents() {
        System.out.println("\nSTUDENT MANAGEMENT:");
        System.out.println("1. Add Student");
        System.out.println("2. List All Students");
        System.out.println("3. Update Student");
        System.out.println("4. Deactivate Student");
        System.out.println("5. View Student Transcript");

        int choice = getIntInput("Enter your choice: ");
        switch (choice) {
            case 1 -> addStudent();
            case 2 -> listStudents();
            case 3 -> updateStudent();
            case 4 -> deactivateStudent();
            case 5 -> viewTranscript();
            default -> System.out.println("Invalid choice!");
        }
    }

    private void addStudent() {
        System.out.println("\nADD NEW STUDENT:");
        String id = getStringInput("Enter Student ID: ");
        String regNo = getStringInput("Enter Registration Number: ");
        String fullName = getStringInput("Enter Full Name: ");
        String email = getStringInput("Enter Email: ");

        Student student = new Student(id, regNo, fullName, email);
        studentService.addStudent(student);
        System.out.println("Student added successfully!");
    }

    private void listStudents() {
        System.out.println("\nALL STUDENTS:");
        List<Student> students = studentService.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            students.forEach(System.out::println);
        }
    }

    private void updateStudent() {
        String id = getStringInput("Enter Student ID to update: ");
        Student student = studentService.getStudent(id);
        if (student != null) {
            String fullName = getStringInput("Enter new Full Name: ");
            String email = getStringInput("Enter new Email: ");
            studentService.updateStudent(id, fullName, email);
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    private void deactivateStudent() {
        String id = getStringInput("Enter Student ID to deactivate: ");
        studentService.deactivateStudent(id);
        System.out.println("Student deactivated successfully!");
    }

    private void viewTranscript() {
        String id = getStringInput("Enter Student ID: ");
        Student student = studentService.getStudent(id);
        if (student != null) {
            System.out.println("\nTRANSCRIPT FOR: " + student.getFullName());
            System.out.println("Registration No: " + student.getRegNo());
            System.out.println("Overall GPA: " + String.format("%.2f", student.calculateGPA()));
            System.out.println("\nEnrollments:");
            student.getEnrollments().forEach(System.out::println);
        } else {
            System.out.println("Student not found!");
        }
    }

    private void manageCourses() {
        System.out.println("\nCOURSE MANAGEMENT:");
        System.out.println("1. Add Course");
        System.out.println("2. List All Courses");
        System.out.println("3. Search Courses by Instructor");
        System.out.println("4. Search Courses by Department");

        int choice = getIntInput("Enter your choice: ");
        switch (choice) {
            case 1 -> addCourse();
            case 2 -> listCourses();
            case 3 -> searchCoursesByInstructor();
            case 4 -> searchCoursesByDepartment();
            default -> System.out.println("Invalid choice!");
        }
    }

    private void addCourse() {
        System.out.println("\nADD NEW COURSE:");
        String code = getStringInput("Enter Course Code: ");
        String title = getStringInput("Enter Course Title: ");
        int credits = getIntInput("Enter Credits: ");
        String instructor = getStringInput("Enter Instructor: ");
        String department = getStringInput("Enter Department: ");

        Course course = new Course.Builder(code, title)
                .credits(credits)
                .instructor(instructor)
                .department(department)
                .build();
        courseService.addCourse(course);
        System.out.println("Course added successfully!");
    }

    private void listCourses() {
        System.out.println("\nALL COURSES:");
        List<Course> courses = courseService.getAllCourses();
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
        } else {
            courses.forEach(System.out::println);
        }
    }

    private void searchCoursesByInstructor() {
        String instructor = getStringInput("Enter Instructor Name: ");
        List<Course> courses = courseService.getCoursesByInstructor(instructor);
        System.out.println("\nCOURSES BY INSTRUCTOR: " + instructor);
        courses.forEach(System.out::println);
    }

    private void searchCoursesByDepartment() {
        String department = getStringInput("Enter Department: ");
        List<Course> courses = courseService.getCoursesByDepartment(department);
        System.out.println("\nCOURSES BY DEPARTMENT: " + department);
        courses.forEach(System.out::println);
    }

    private void manageEnrollments() {
        System.out.println("\nENROLLMENT MANAGEMENT:");
        String studentId = getStringInput("Enter Student ID: ");
        Student student = studentService.getStudent(studentId);
        
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.println("1. Enroll in Course");
        System.out.println("2. View Current Enrollments");
        
        int choice = getIntInput("Enter your choice: ");
        switch (choice) {
            case 1 -> enrollStudent(student);
            case 2 -> {
                System.out.println("\nCURRENT ENROLLMENTS:");
                student.getEnrollments().forEach(System.out::println);
            }
            default -> System.out.println("Invalid choice!");
        }
    }

    private void enrollStudent(Student student) {
        System.out.println("\nENROLL IN COURSE:");
        String courseCode = getStringInput("Enter Course Code: ");
        Course course = courseService.getCourse(courseCode);
        
        if (course == null) {
            System.out.println("Course not found!");
            return;
        }

        System.out.println("Available Semesters:");
        for (semester semester : semester.values()) {
            System.out.println(semester.ordinal() + 1 + ". " + semester.getDescription() + " (" + semester.getDuration() + ")");
        }
        
        int semChoice = getIntInput("Select Semester: ") - 1;
        if (semChoice < 0 || semChoice >= semester.values().length) {
            System.out.println("Invalid semester choice!");
            return;
        }

        semester semester = semester.values()[semChoice];
        int academicYear = getIntInput("Enter Academic Year: ");

        try {
            // Check for duplicate enrollment
            boolean alreadyEnrolled = student.getEnrollments().stream()
                    .anyMatch(e -> e.getCourse().getCode().equals(courseCode) 
                                && e.getSemester() == semester 
                                && e.getAcademicYear() == academicYear);
            
            if (alreadyEnrolled) {
                throw new DuplicateEnrollmentException("Student is already enrolled in this course for the selected semester and year");
            }

            // Check credit limit
            int currentCredits = student.getEnrollments().stream()
                    .filter(e -> e.getSemester() == semester && e.getAcademicYear() == academicYear)
                    .mapToInt(e -> e.getCourse().getCredits())
                    .sum();

            if (currentCredits + course.getCredits() > AppConfig.getInstance().getMaxCreditsPerSemester()) {
                throw new MaxCreditLimitExceededException(
                    "Credit limit exceeded! Current: " + currentCredits + 
                    ", Attempting to add: " + course.getCredits() + 
                    ", Max allowed: " + AppConfig.getInstance().getMaxCreditsPerSemester());
            }

            student.enrollInCourse(course, semester, academicYear);
            System.out.println("Enrollment successful!");

        } catch (DuplicateEnrollmentException | MaxCreditLimitExceededException e) {
            System.out.println("Enrollment failed: " + e.getMessage());
        }
    }

    private void manageGrades() {
        System.out.println("\nGRADE MANAGEMENT:");
        String studentId = getStringInput("Enter Student ID: ");
        Student student = studentService.getStudent(studentId);
        
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.println("Current Enrollments:");
        List<Enrollment> enrollments = student.getEnrollments();
        for (int i = 0; i < enrollments.size(); i++) {
            Enrollment enrollment = enrollments.get(i);
            System.out.println((i + 1) + ". " + enrollment.getCourse().getCode() + 
                             " - " + enrollment.getCourse().getTitle() +
                             " (" + enrollment.getSemester() + " " + enrollment.getAcademicYear() + ")");
        }

        int choice = getIntInput("Select enrollment to grade (0 to cancel): ") - 1;
        if (choice < 0 || choice >= enrollments.size()) {
            System.out.println("Invalid selection!");
            return;
        }

        Enrollment enrollment = enrollments.get(choice);
        double marks = getDoubleInput("Enter marks for " + enrollment.getCourse().getTitle() + ": ");
        
        enrollment.recordMarks(marks);
        System.out.println("Marks recorded, now Grade: " + enrollment.getGrade());
        System.out.println("Grade Points: " + enrollment.getGrade().getGradePoints());
    }

    private void importExportData() {
        System.out.println("\nIMPORT/EXPORT DATA:");
        System.out.println("1. Export Students to CSV");
        System.out.println("2. Export Courses to CSV");

        int choice = getIntInput("Enter your choice: ");
        try {
            switch (choice) {
                case 1 -> {
                    fileService.exportStudentsToCSV(studentService.getAllStudents(), "students.csv");
                    System.out.println("Students exported to students.csv");
                }
                case 2 -> {
                    fileService.exportCoursesToCSV(courseService.getAllCourses(), "courses.csv");
                    System.out.println("Courses exported to courses.csv");
                }
                default -> System.out.println("Invalid choice!");
            }
        } catch (IOException e) {
            System.out.println("Error during export: " + e.getMessage());
        }
    }

    private void backupOperations() {
        System.out.println("\nBACKUP OPERATIONS:");
        System.out.println("1. Create Backup");
        System.out.println("2. Calculate Backup Size");
        System.out.println("3. List Backup Files");

        int choice = getIntInput("Enter your choice: ");
        try {
            switch (choice) {
                case 1 -> {
                    fileService.backupData();
                    System.out.println("Backup created successfully!");
                }
                case 2 -> {
                    long size = fileService.calculateBackupSize();
                    System.out.println("Total backup size: " + String.format("%,d", size) + " bytes");
                }
                case 3 -> {
                    int depth = getIntInput("Enter maximum depth to list: ");
                    fileService.listBackupFiles(depth);
                }
                default -> System.out.println("Invalid choice!");
            }
        } catch (IOException e) {
            System.out.println("Error during backup operation: " + e.getMessage());
        }
    }

    private void generateReports() {
        System.out.println("\nREPORTS:");
        System.out.println("1. Top Students by GPA");
        System.out.println("2. GPA Distribution");

        int choice = getIntInput("Enter your choice: ");
        switch (choice) {
            case 1 -> {
                int count = getIntInput("Enter number of top students to display: ");
                List<Student> topStudents = studentService.getTopStudents(count);
                System.out.println("\nTOP " + count + " STUDENTS:");
                topStudents.forEach(s -> System.out.println(s.getFullName() + " - GPA: " + 
                    String.format("%.2f", s.calculateGPA())));
            }
            case 2 -> {
                System.out.println("\nGPA DISTRIBUTION:");
                List<Student> students = studentService.getAllStudents();
                students.stream()
                    .collect(java.util.stream.Collectors.groupingBy(
                        s -> {
                            double gpa = s.calculateGPA();
                            if (gpa >= 9.0) return "S Grade (9.0+)";
                            else if (gpa >= 8.0) return "A Grade (8.0-8.9)";
                            else if (gpa >= 7.0) return "B Grade (7.0-7.9)";
                            else if (gpa >= 6.0) return "C Grade (6.0-6.9)";
                            else if (gpa >= 5.0) return "D Grade (5.0-5.9)";
                            else return "F Grade (<5.0)";
                        },
                        java.util.stream.Collectors.counting()
                    ))
                    .forEach((gradeRange, count) -> 
                        System.out.println(gradeRange + ": " + count + " students"));
            }
            default -> System.out.println("Invalid choice!");
        }
    }

    private void displayJavaInfo() {
        System.out.println("\nJAVA PLATFORM INFORMATION:");
        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println("JVM Vendor: " + System.getProperty("java.vm.vendor"));
        System.out.println("JVM Version: " + System.getProperty("java.vm.version"));
        System.out.println("OS: " + System.getProperty("os.name") + " " + System.getProperty("os.version"));
        System.out.println("Architecture: " + System.getProperty("os.arch"));
        System.out.println("Available Processors: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Max Memory: " + Runtime.getRuntime().maxMemory() / (1024 * 1024) + " MB");
    }

    private int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number!");
            scanner.next();
            System.out.print(prompt);
        }
        int input = scanner.nextInt();
        scanner.nextLine(); 
        return input;
    }

    private double getDoubleInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Please enter a valid number!");
            scanner.next();
            System.out.print(prompt);
        }
        double input = scanner.nextDouble();
        scanner.nextLine(); 
        return input;
    }

    private String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public static void main(String[] args) {
        ccrm_main app = new ccrm_main();
        app.start();
    }
}