package edu.ccrm.io;

import edu.ccrm.config.AppConfig;
import edu.ccrm.domain.Student;
import edu.ccrm.domain.Course;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileService {
    private AppConfig config;

    public FileService() {
        this.config = AppConfig.getInstance();
    }

    public void exportStudentsToCSV(List<Student> students, String filename) throws IOException {
        Path filePath = config.getDataDirectory().resolve(filename);
        Files.createDirectories(config.getDataDirectory());

        List<String> lines = students.stream()
                .map(student -> String.format("%s,%s,%s,%s,%s",
                        student.getId(), student.getRegNo(), 
                        student.getFullName(), student.getEmail(), 
                        student.isActive()))
                .collect(Collectors.toList());

        lines.add(0, "ID,RegNo,FullName,Email,Active");
        Files.write(filePath, lines);
    }

    public void exportCoursesToCSV(List<Course> courses, String filename) throws IOException {
        Path filePath = config.getDataDirectory().resolve(filename);
        Files.createDirectories(config.getDataDirectory());

        List<String> lines = courses.stream()
                .map(course -> String.format("%s,%s,%d,%s,%s,%s",
                        course.getCode(), course.getTitle(), course.getCredits(),
                        course.getInstructor(), course.getDepartment(), course.isActive()))
                .collect(Collectors.toList());

        lines.add(0, "Code,Title,Credits,Instructor,Department,Active");
        Files.write(filePath, lines);
    }

    public void backupData() throws IOException {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        Path backupPath = config.getBackupDirectory().resolve("backup_" + timestamp);

        Files.createDirectories(backupPath);

        // Copy all CSV files from data directory to backup
        if (Files.exists(config.getDataDirectory())) {
            try (Stream<Path> paths = Files.walk(config.getDataDirectory())) {
                paths.filter(Files::isRegularFile)
                     .filter(path -> path.toString().endsWith(".csv"))
                     .forEach(path -> {
                         try {
                             Files.copy(path, backupPath.resolve(path.getFileName()), 
                                      StandardCopyOption.REPLACE_EXISTING);
                         } catch (IOException e) {
                             System.err.println("Error copying file: " + path);
                         }
                     });
            }
        }

        System.out.println("Backup created at: " + backupPath);
    }

    public long calculateBackupSize() throws IOException {
        Path backupDir = config.getBackupDirectory();
        return calculateDirectorySize(backupDir);
    }

    // Recursive method to calculate directory size
    private long calculateDirectorySize(Path directory) throws IOException {
        if (!Files.exists(directory) || !Files.isDirectory(directory)) {
            return 0;
        }

        try (Stream<Path> paths = Files.walk(directory)) {
            return paths.filter(Files::isRegularFile)
                       .mapToLong(path -> {
                           try {
                               return Files.size(path);
                           } catch (IOException e) {
                               return 0;
                           }
                       })
                       .sum();
        }
    }

    public void listBackupFiles(int maxDepth) throws IOException {
        Path backupDir = config.getBackupDirectory();
        listFilesRecursive(backupDir, 0, maxDepth);
    }

    // Recursive method to list files with depth
    private void listFilesRecursive(Path directory, int currentDepth, int maxDepth) throws IOException {
        if (currentDepth > maxDepth || !Files.exists(directory)) {
            return;
        }

        String indent = "  ".repeat(currentDepth);
        System.out.println(indent + directory.getFileName());

        try (Stream<Path> paths = Files.list(directory)) {
            paths.forEach(path -> {
                String fileIndent = "  ".repeat(currentDepth + 1);
                if (Files.isDirectory(path)) {
                    System.out.println(fileIndent + path.getFileName());
                    try {
                        listFilesRecursive(path, currentDepth + 1, maxDepth);
                    } catch (IOException e) {
                        System.err.println("Error accessing directory: " + path);
                    }
                } else {
                    try {
                        String size = String.format("%,d bytes", Files.size(path));
                        System.out.println(fileIndent + path.getFileName() + " (" + size + ")");
                    } catch (IOException e) {
                        System.out.println(fileIndent + path.getFileName() + " (Error reading size)");
                    }
                }
            });
        }
    }
}