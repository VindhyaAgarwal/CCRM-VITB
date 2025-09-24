package edu.ccrm.util;

import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;

public class RecursionUtil {
    public static int countFiles(Path directory) {
        try {
            return (int) Files.list(directory)
                    .mapToInt(path -> {
                        if (Files.isDirectory(path)) {
                            return countFiles(path); // Recursive call
                        } else {
                            return 1;
                        }
                    })
                    .sum();
        } catch (IOException e) {
            return 0;
        }
    }
    public static void printDirectoryStructure(Path directory, int depth) {
        try {
            Files.list(directory)
                 .forEach(path -> {
                     String indent = "  ".repeat(depth);
                     System.out.println(indent + path.getFileName());
                     if (Files.isDirectory(path)) {
                         printDirectoryStructure(path, depth + 1); // Recursive call
                     }
                 });
        } catch (IOException e) {
            System.err.println("Error reading directory: " + e.getMessage());
        }
    }
}