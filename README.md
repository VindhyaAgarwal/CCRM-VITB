# VIT Bhopal Campus Course & Records Manager (CCRM)

![Java Version](https://img.shields.io/badge/Java-17+-blue?logo=openjdk)
![Platform](https://img.shields.io/badge/Platform-Windows%20%7C%20macOS%20%7C%20Linux-brightgreen)
![IDE](https://img.shields.io/badge/IDE-Eclipse-blueviolet?logo=eclipseide)
![Status](https://img.shields.io/badge/Status-Active-success)
![License](https://img.shields.io/badge/License-MIT-yellow)

> A powerful, yet easy-to-use Java console application designed specifically to manage student records, courses, enrollments, and grades at VIT Bhopal University. It's a full-fledged management system that handles everything from CRUD operations to data backups, all managed right from your command line.

---

## 📚 Table of Contents
* [ Getting Started](#-getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation & Setup](#installation--setup-guide)
* [ Detailed Installation Guides](#️-detailed-installation-guides)
  * [Windows JDK Setup](#step-by-step-windows-installation)
  * [Eclipse Project Setup](#step-by-step-eclipse-setup)
* [ Project Deep Dive](#-project-deep-dive)
  * [Connecting Syllabus to Source Code](#connecting-the-dots-syllabus-to-source-code)
  * [Enabling Assertions](#how-to-enable-assertions)
  * [Features at a Glance](#-features-at-a-glance)
  * [Project File Structure](#-project-file-structure)
* [Java Concepts Explained (Optional)](#-java-concepts-explained-optional)
* [ Support](#-support)

---

##  Getting Started

Ready to fire it up? Here’s what you’ll need and how to get the project running on your machine.

### Prerequisites
* **Java JDK**: Version **17** or higher is required.
* **IDE**: **Eclipse IDE 2023-09** (or a newer version) is recommended.
* **OS**: Works smoothly on Windows 10/11, macOS, or any major Linux distribution.

### Installation & Setup Guide

#### 1. Install Java (JDK 17+)
- Head over to the [Oracle JDK downloads page](https://www.oracle.com/java/technologies/downloads/) and grab the installer for your OS.
- Run the installer and click through the setup wizard.
- **Crucial Step**: Set up your `JAVA_HOME` environment variable to point to the installation directory.
- Open a new terminal and verify with `java -version`.

#### 2. Set Up Eclipse IDE
- Download the **Eclipse IDE for Enterprise Java and Web Developers** from the [official Eclipse downloads page](https://www.eclipse.org/downloads/).
- Extract the zip file to a convenient location (like `C:\eclipse`).
- Run `eclipse.exe` and choose a directory for your workspace.

#### 3. Import the Project into Eclipse
- Inside Eclipse, go to **File → Import → Git → Projects from Git**.
- Select the **Clone URI** option and paste the repository URL: `https://github.com/VindhyaAgarwal/CCRM-VITB.git`
- Follow the import wizard; the default options should work fine.

#### 4. Configure the Project's Build Path
- Right-click on the project in the *Package Explorer* and go to **Build Path → Configure Build Path**.
- In the **Libraries** tab, ensure the JRE System Library is set to your **JDK 17+** installation.
- Click **Apply and Close**.

#### 5. Run the Application!
- Find the main entry point: `src/edu/ccrm/cli/ccrm_main.java`.
- Right-click the file and select **Run As → Java Application**.
- The console will open with the menu-driven interface. You're all set!

---

##  Detailed Installation Guides

Here are more detailed, step-by-step guides for setting up your environment.

### Step-by-Step: Windows Installation
1.  **Download the JDK**: Go to the [Oracle JDK downloads page](https://www.oracle.com/java/technologies/downloads/) and download the **Windows x64 MSI Installer** for Java 17+.
2.  **Install the JDK**: Right-click the downloaded `.msi` file and **Run as Administrator**. Follow the on-screen prompts. Note the installation path (e.g., `C:\Program Files\Java\jdk-21\`).
3.  **Set Environment Variables**:
    * Press `Win + X` → **System** → **Advanced system settings**.
    * Click the **Environment Variables...** button.
    * Under *System variables*, click **New...** to create `JAVA_HOME`.
      * **Variable name**: `JAVA_HOME`
      * **Variable value**: `C:\Program Files\Java\jdk-21` (your path)
    * Find the `Path` variable, click **Edit...**, and add a new entry: `%JAVA_HOME%\bin`.
4.  **Verify Everything Works**: Open a **new** Command Prompt and run these commands:
    ```cmd
    java -version
    javac -version
    echo %JAVA_HOME%
    ```
    ![JDK installation verification](https://github.com/user-attachments/assets/57046838-df94-45dd-91de-6210cc35cba3)

### Step-by-Step: Eclipse Setup
1.  **Download and Run Eclipse**: Go to the [Eclipse Downloads page](https://www.eclipse.org/downloads/) and get the **Eclipse IDE for Enterprise Java and Web Developers**. Extract and run `eclipse.exe`.
2.  **Workspace**: When prompted, select a location for your workspace. The default is usually fine. Close the "Welcome" screen.
3.  **Import Project**: Navigate to **File → Import → Git → Projects from Git**. Choose **Clone URI** and paste the repository URL. Step through the wizard and click **Finish**.
4.  **Link Your JDK**: Go to **Window → Preferences → Java → Installed JREs**. Click **Add...**, select **Standard VM**, and navigate to your JDK 17+ installation directory. Check the box next to it to set it as the default. Click **Apply and Close**.
    
    ![Eclipse Installation](https://github.com/user-attachments/assets/f2f8d735-1f85-456c-a331-210615aed261)
    ![Eclipse project setup](https://github.com/user-attachments/assets/e1e79d64-281d-45bd-a35c-b63b70b2c96c)

---

##  Project Deep Dive

### Connecting the Dots: Syllabus to Source Code
This project serves as a practical application of key computer science concepts. Here’s where you can find them in the codebase:

| Syllabus Topic            | Where to Find It                                   | File / Class / Method                                   |
| ------------------------- | -------------------------------------------------- | ------------------------------------------------------- |
| **OOP Principles** | The core data models of the application.           | All classes in `src/edu/ccrm/domain/`                   |
| **Encapsulation** | All domain classes protect their state.            | Private fields with public getters/setters.             |
| **Inheritance** | A `Student` is a specialized type of `Person`.     | `Person.java`, `Student.java`                           |
| **Polymorphism** | Different classes provide their own search logic.  | `Searchable.java` interface and its implementations.    |
| **Abstract Classes** | The `Person` class provides a template.            | `Person.java` is declared as `abstract`.                |
| **Interfaces** | Defines contracts for searching and saving.        | `Searchable.java`, `Persistable.java`                   |
| **File I/O (NIO.2)** | Reading from and writing to files.                 | `FileService.java`                                      |
| **Collections Framework** | Managing lists of students, courses, etc.          | All service classes (e.g., `StudentService.java`).      |
| **Stream API & Lambdas** | Powerful, declarative data processing.             | `search()` and `getTopStudents()` methods.              |
| **Design Patterns** | For robust and maintainable code architecture.     | `AppConfig.java` (Singleton), `Course.java` (Builder).  |
| **Recursion** | For operations that involve traversing directories.| `RecursionUtil.java` (e.g., for backups).               |

###  How to Enable Assertions
Assertions are great for catching bugs by verifying assumptions in your code. They are disabled by default.

* **Via Command Line**: Use the `-ea` flag.
    ```bash
    java -ea -cp bin edu.ccrm.cli.ccrm_main
    ```
* **In Eclipse**:
    1. Go to **Run → Run Configurations...**.
    2. Select your `ccrm_main` launch configuration.
    3. Go to the **Arguments** tab and in the **VM arguments** box, type `-ea`.
    4. Click **Apply**, then **Run**.

###  Features at a Glance

#### Core Functionality
-   * **Student Management**: Full CRUD (Create, Read, Update, Delete) operations.
-   * **Course Management**: Easy course creation using the Builder pattern.
-   * **Enrollment System**: Handles enrollments with built-in business rule validation.
-   * **VIT Bhopal Grading**: Implements the official grading system for accurate calculations.
-   * **GPA & Transcripts**: Automatically calculates GPA and can generate student transcripts.
-   * **Data Import/Export**: Load and save data in a universal CSV format.
-   * **Backup System**: Create backups of all application data with a single command.

#### Technical Highlights
-   * **Modern OOP**: Cleanly structured with SOLID principles in mind.
-   * **Robust Exception Handling**: Uses custom exceptions for clear error reporting.
-   * **Advanced File I/O**: Leverages the modern Java NIO.2 library.
-   * **Functional Programming**: Uses the Stream API and Lambda expressions for efficiency.
-   * **Proven Design Patterns**: Employs Singleton and Builder patterns.
-   * **Recursive Algorithms**: Demonstrates recursion for directory traversal.

###  Project File Structure

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
##  Java Concepts Explained 

Let's learn more about the Java ecosystem:-

### A Quick Trip Down Java Lane
This project stands on the shoulders of giants! Here's a quick look at how Java has evolved.
* **1995**: Java 1.0 is released.
* **1998**: Java 1.2 introduces the game-changing Collections Framework.
* **2004**: Java 5 brings generics, autoboxing, and annotations.
* **2014**: **Java 8** revolutionizes the language with Lambda expressions and the Stream API.
* **2018**: **Java 11 LTS** arrives with a new HTTP client and the `var` keyword.
* **2021**: **Java 17 LTS** is released, featuring sealed classes and enhanced pattern matching.
* **2023**: **Java 21 LTS** introduces virtual threads, pushing performance forward.

### The Core Trio: JDK vs. JRE vs. JVM
* **JVM (Java Virtual Machine)**: The engine that runs your compiled Java code. It's the magic that makes "Write Once, Run Anywhere" possible.
* **JRE (Java Runtime Environment)**: Everything needed to *run* a Java application (JVM + Core Libraries). This is what end-users need.
* **JDK (Java Development Kit)**: The full toolkit for *developing* Java applications (JRE + Tools like `javac`). This is what developers need.
    > In short: **JDK ⊃ JRE ⊃ JVM**

### Java Platforms: SE vs. ME vs. EE
| Aspect               | Java SE (Standard Edition)    | Java ME (Micro Edition)         | Java EE (Enterprise Edition)       |
| -------------------- | ----------------------------- | ------------------------------- | ---------------------------------- |
| **What It's For** | Desktop & console applications| Embedded devices, IoT, sensors  | Enterprise-grade web applications  |
| **Example** | **This Project**, desktop tools    | Old mobile apps, smart cards    | Web services, large-scale systems  |


---

##  Support
For any issues, questions, or suggestions, please feel free to open an issue on GitHub!

---
**Developed for VIT Bhopal University - Computer Science Department** **Vityarthi Academic Project - Campus Course & Records Manager** **© 2024 VIT Bhopal University**
