````markdown
# VIT Bhopal Campus Course & Records Manager (CCRM)

CCRM is a powerful, yet easy-to-use Java console application designed to manage student records, courses, enrollments, and grades specifically for VIT Bhopal University. This isn't just a simple student tracker; CCRM is a full-fledged management system that handles everything from student and course details (with full CRUD) to enrollments, grading (mirroring VIT Bhopal's official system!), and even data backups. It's all managed right from your console.

---

## Getting Started

Ready to fire it up? Here’s what you’ll need and how to get the project running on your machine.

### Prerequisites
* **Java JDK**: Version **17** or higher is required.
* **IDE**: **Eclipse IDE 2023-09** (or a newer version) is recommended.
* **OS**: Works smoothly on Windows 10/11, macOS, or any major Linux distribution.

### Installation & Setup Guide

#### Step 1: Get JDK 17+ on Your Machine
1.  Head over to the [Oracle JDK downloads page](https://www.oracle.com/java/technologies/downloads/) and grab the installer for your OS.
2.  Run the installer and click through the setup wizard.
3.  **Crucial Step**: Set up your `JAVA_HOME` environment variable to point to the installation directory.
4.  Open a new terminal or command prompt and verify the installation:
    ```bash
    java -version
    ```

#### Step 2: Set Up Eclipse IDE
1.  Download the **Eclipse IDE for Enterprise Java and Web Developers** from the [official Eclipse downloads page](https://www.eclipse.org/downloads/).
2.  It's a zip file, so just extract it to a convenient location (like `C:\eclipse`).
3.  Run `eclipse.exe` (or the executable for your OS).
4.  Choose a directory for your workspace when prompted.

#### Step 3: Import the Project into Eclipse
1.  Inside Eclipse, go to **File → Import → Git → Projects from Git**.
2.  Select the **Clone URI** option.
3.  Paste the repository URL: `https://github.com/yourusername/CCRM-VIT-Bhopal.git`
4.  Follow the import wizard; the default options should work fine.
5.  Click **Finish** to complete the import.

#### Step 4: Configure the Project's Build Path
1.  Right-click on the project in the *Package Explorer* and go to **Build Path → Configure Build Path**.
2.  In the **Libraries** tab, make sure the JRE System Library is set to your **JDK 17+** installation.
3.  Click **Apply and Close**.

#### Step 5: Run the Application!
1.  Find the main entry point of the application: `src/edu/ccrm/cli/ccrm_main.java`.
2.  Right-click the file and select **Run As → Java Application**.
3.  The console will open with a menu-driven interface. You're all set!

### Alternative: Running from the Command Line
If you prefer the command line, follow these steps:
```bash
# First, clone the repository
git clone [https://github.com/VindhyaAgarwal/CCRM-VITB.git]
cd CCRM-VITB

# Compile all the .java files into the bin directory
javac -d bin src/edu/ccrm/**/*.java

# Run the main class
java -cp bin edu.ccrm.cli.ccrm_main
```

---

## 📚 A Quick Trip Down Java Lane

Java has come a long way since its inception. This project leverages modern features from recent LTS releases.

* **1995**: Java 1.0 is released by Sun Microsystems.
* **1998**: Java 1.2 (J2SE) introduces the game-changing Collections Framework.
* **2004**: Java 5 brings generics, autoboxing, and annotations, making code safer and cleaner.
* **2011**: Java 7 adds helpful syntax like the try-with-resources and the diamond operator.
* **2014**: **Java 8** revolutionizes the language with Lambda expressions and the Stream API.
* **2017**: Java 9 introduces the module system (Project Jigsaw).
* **2018**: **Java 11 LTS** arrives with a new HTTP client and the `var` keyword for local variables.
* **2021**: **Java 17 LTS** is released, featuring sealed classes and enhanced pattern matching.
* **2023**: **Java 21 LTS** introduces virtual threads and record patterns, pushing performance forward.

---

## ⚖️ Java Platforms: SE vs. ME vs. EE

Java isn't one-size-fits-all. Here’s a quick comparison to show where this project (a Java SE app) fits in.

| Aspect               | Java ME (Micro Edition)         | Java SE (Standard Edition)    | Java EE (Enterprise Edition)       |
| -------------------- | ------------------------------- | ----------------------------- | ---------------------------------- |
| **Target Platform** | Embedded devices, IoT, sensors  | Desktop & console applications| Enterprise-grade web applications  |
| **API Scope** | A small subset of core APIs     | The core Java features        | Extended APIs for web & services   |
| **Memory Footprint** | Tiny (~MBs)                     | Medium (~10s of MBs)          | Large (100+ MBs)                   |
| **Use Cases** | Old mobile apps, smart cards    | **This Project**, desktop tools | Web services, large-scale systems  |
| **Key Technologies** | MIDP, CLDC                      | Swing, JavaFX, Core APIs      | Servlets, JSP, EJB, JPA            |

---

## 🔧 The Core Trio: JDK vs. JRE vs. JVM

Here’s how the Java ecosystem components stack up.

### JVM (Java Virtual Machine)
* **What it is**: The magic box that actually runs your compiled Java bytecode.
* **Its Superpower**: It provides platform independence, fulfilling the "Write Once, Run Anywhere" promise.
* **Inside**: It has a class loader, memory areas (like the heap and stack), and an execution engine.

### JRE (Java Runtime Environment)
* **What it is**: The software package that provides everything needed to *run* a Java application.
* **Inside**: It contains the **JVM** and the core Java libraries.
* **Who needs it**: End-users who just want to run a Java program need the JRE.

### JDK (Java Development Kit)
* **What it is**: The full toolkit for *developing* Java applications.
* **Inside**: It contains the entire **JRE** plus development tools like the compiler (`javac`), archiver (`jar`), and documentation generator (`javadoc`).
* **Who needs it**: Developers need the JDK to write, compile, and debug Java code.

**In short: `JDK ⊃ JRE ⊃ JVM`**

---

## 🖥️ Detailed Windows Installation Steps

### Step 1: Download the JDK
1.  Go to the [Oracle JDK downloads page](https://www.oracle.com/java/technologies/downloads/).
2.  Find the Java 17 (or newer) section and download the **Windows x64 MSI Installer**.
3.  Save the `.msi` file to your computer.

### Step 2: Install the JDK
1.  Right-click the downloaded installer and **Run as Administrator**.
2.  Follow the on-screen prompts in the installation wizard.
3.  Take note of the installation path (it's usually `C:\Program Files\Java\jdk-21\`).

### Step 3: Set Up Environment Variables
1.  Press `Win + X` and click on **System**, then go to **Advanced system settings**.
2.  Click the **Environment Variables...** button.
3.  Under *System variables*, click **New...** to create `JAVA_HOME` if it doesn't exist.
    * Variable name: `JAVA_HOME`
    * Variable value: `C:\Program Files\Java\jdk-21` (or your installation path)
4.  Find the `Path` variable, click **Edit...**, and add a new entry: `%JAVA_HOME%\bin`.

### Step 4: Verify Everything Works
Open a **new** Command Prompt and run these commands to confirm:
```cmd
java -version
javac -version
echo %JAVA_HOME%
```
You should see the versions of Java and the compiler, along with the path you just set.

<img width="1919" height="1011" alt="JDK installation verification" src="https://github.com/user-attachments/assets/57046838-df94-45dd-91de-6210cc35cba3" />


---

## ⚙️ Detailed Eclipse Setup Steps

### Step 1: Download and Run Eclipse
1.  Go to the [Eclipse Downloads page](https://www.eclipse.org/downloads/).
2.  Download the installer or the zip file for **Eclipse IDE for Enterprise Java and Web Developers**.
3.  If it's a zip, extract it. Then, run `eclipse.exe`.

### Step 2: Workspace and Welcome
1.  The first time you run Eclipse, it will ask for a workspace location. The default is usually fine.
2.  Once it loads, you can close the "Welcome" screen to get to the main interface.

### Step 3: Import the CCRM Project
1.  Go to **File → Import → Git → Projects from Git**.
2.  Choose **Clone URI** and paste the repository URL:
    * URI: `https://github.com/VindhyaAgarwal/CCRM-VITBl.git`
3.  You may need to enter your GitHub credentials if the repository is private.
4.  Step through the wizard and click **Finish**.

### Step 4: Link Your JDK
1.  Go to **Window → Preferences → Java → Installed JREs**.
2.  Click **Add...**, select **Standard VM**, and navigate to your JDK 17+ installation directory.
3.  Check the box next to your newly added JDK to set it as the default.
4.  Click **Apply and Close**.

<img width="1919" height="1006" alt="Eclipse Installation" src="https://github.com/user-attachments/assets/f2f8d735-1f85-456c-a331-210615aed261" />
<img width="1919" height="1011" alt="Eclipse project setup" src="https://github.com/user-attachments/assets/e1e79d64-281d-45bd-a35c-b63b70b2c96c" />


---

## 📖 Connecting the Dots: Syllabus to Source Code

This project was built to be a practical application of key computer science concepts. Here’s a map of syllabus topics to their implementation in the CCRM codebase.

| Syllabus Topic            | Where to Find It                                   | File / Class / Method                                   |
| ------------------------- | -------------------------------------------------- | ------------------------------------------------------- |
| **OOP Principles** | The core data models of the application.           | All classes in `src/edu/ccrm/domain/`                   |
| **Encapsulation** | All domain classes protect their state.            | Private fields with public getters/setters.             |
| **Inheritance** | A `Student` is a specialized type of `Person`.     | `Person.java`, `Student.java`                           |
| **Polymorphism** | Different classes provide their own search logic.  | `Searchable.java` interface and its implementations.    |
| **Abstract Classes** | The `Person` class provides a template.            | `Person.java` is declared as `abstract`.                |
| **Interfaces** | Defines contracts for searching and saving.        | `Searchable.java`, `Persistable.java`                   |
| **Enums** | For type-safe grades and semesters.                | `Grade.java`, `Semester.java`                           |
| **Exception Handling** | Graceful error handling for invalid operations.    | All classes in `src/edu/ccrm/exceptions/`               |
| **File I/O (NIO.2)** | Reading from and writing to files.                 | `FileService.java`                                      |
| **Collections Framework** | Managing lists of students, courses, etc.          | All service classes (e.g., `StudentService.java`).      |
| **Stream API** | Powerful, declarative data processing.             | `search()` and `getTopStudents()` methods.              |
| **Lambda Expressions** | Concise, functional-style code.                    | Used with streams for filtering, mapping, etc.          |
| **Design Patterns** | For robust and maintainable code architecture.     | `AppConfig.java` (Singleton), `Course.java` (Builder).  |
| **Recursion** | For operations that involve traversing directories.| `RecursionUtil.java` (e.g., for backups).               |
| **Date/Time API** | Handling timestamps accurately.                    | `LocalDateTime` used for `submitted_at` fields.         |

---

## 🧪 How to Enable Assertions

Assertions are a great way to catch bugs during development by verifying assumptions in your code. They are disabled by default.

### Enable Assertions via Command Line:
Use the `-ea` (enable assertions) flag when you run the application.
```bash
java -ea -cp bin edu.ccrm.cli.ccrm_main
```

### Enable Assertions in Eclipse:
1.  Go to **Run → Run Configurations...**.
2.  Select your `CCRMMain` launch configuration under *Java Application*.
3.  Go to the **Arguments** tab.
4.  In the **VM arguments** box, type `-ea`.
5.  Click **Apply**, then **Run**.

### Sample Assertion in the Code:
Here’s how assertions are used to enforce rules before processing a student object.
```java
public void validateStudent(Student student) {
    // Ensure the student object itself isn't null
    assert student != null : "Student object cannot be null";

    // Ensure the ID is present
    assert student.getId() != null && !student.getId().isEmpty() : "Student ID is required";

    // Validate the registration number format with a regex
    assert student.getRegNo().matches("^24BCE\\d{5}$") : "Invalid registration number format";
}
```

---

## 🎯 Features at a Glance

### Core Functionality
-   ✅ **Student Management**: Full CRUD (Create, Read, Update, Delete) operations for students.
-   ✅ **Course Management**: Easily create course objects using the Builder pattern.
-   ✅ **Enrollment System**: Handles student enrollments with built-in business rule validation.
-   ✅ **VIT Bhopal Grading**: Implements the official grading system for accurate calculations.
-   ✅ **GPA & Transcripts**: Automatically calculates GPA and can generate student transcripts.
-   ✅ **Data Import/Export**: Load and save data in a universal CSV format.
-   ✅ **Backup System**: Create backups of all application data with a single command.

### Technical Highlights
-   ✅ **Modern OOP**: Cleanly structured with SOLID principles in mind.
-   ✅ **Robust Exception Handling**: Uses custom exceptions for clear error reporting.
-   ✅ **Advanced File I/O**: Leverages the modern Java NIO.2 library.
-   ✅ **Functional Programming**: Uses the Stream API and Lambda expressions for efficient data processing.
-   ✅ **Proven Design Patterns**: Employs Singleton and Builder patterns for better code structure.
-   ✅ **Recursive Algorithms**: Demonstrates recursion for complex tasks like directory traversal.

---

## 📁 Project File Structure
```
CCRM-VITB/
├── src/edu/ccrm/
│   ├── cli/CCRMMain.java          # Main application entry point & UI
│   ├── domain/                    # Core data models (Student, Course, etc.)
│   ├── service/                   # Business logic and operations
│   ├── io/FileService.java        # All file reading/writing logic
│   ├── util/                      # Helper and utility classes
│   ├── config/AppConfig.java      # App configuration (Singleton)
│   └── exceptions/                # Custom exception classes
├── test-data/                     # Sample CSV files to import
├── data/                          # Default directory for exported files
├── backup/                        # Default directory for backups
├── screenshots/                   # Images used in this README
├── README.md                      # You are here!
└── USAGE.md                       # Detailed usage instructions for the CLI
```

---

## 👥 Sample Data

The application comes with pre-loaded sample data in the `test-data` folder to get you started immediately.
* **Students**: Includes records for students like Vindhya Agarwal.
* **Courses**: Includes courses like Java Programming, DBMS, and Linear Algebra.
* **Enrollments**: Pre-configured enrollments with sample grades are included.

---

## 📞 Support

For any issues, questions, or suggestions regarding this project, please contact 

---
**Developed for VIT Bhopal University - Computer Science Department** **Vityarthi Academic Project - Campus Course & Records Manager** **© 2024 VIT Bhopal University**
````
