# CCRM: A Practical User Guide

Welcome to the Campus Course & Records Manager (CCRM)! This guide will walk you through everything you need to know to run the application, understand its features, and follow a typical workflow.

## Firing It Up: How to Run the App

Getting the application running is a two-step process: compiling the source code and then executing the main program.

### **1. Compiling the Code**

First, navigate to the root directory of the project in your terminal. Then, run the following command to compile all the Java source files into the `bin` directory.

```bash
# This command finds all .java files and compiles them
javac -d bin src/edu/ccrm/**/*.java
```
### **2. Running the Application**
Once the compilation is successful, you can start the application with this command:

```bash
# This command executes the main class
java -cp bin edu.ccrm.cli.ccrm_main
```
#### A Quick Note on Assertions
This project uses assertions to catch potential bugs during development. They are turned off by default. If you want to run the application with these internal checks enabled, just add the -ea flag.

```bash
# Run with assertions enabled for debugging
java -ea -cp bin edu.ccrm.cli.ccrm_main
```

## Navigating the Menu
The application is entirely controlled through a simple, menu-driven interface in your console. When you start it up, you'll see a list of options like this:

* #### 1. Manage Students
* #### 2. Manage Courses
* #### 3. Manage Enrollment & Grades
* #### 4. Run Reports
* #### 5. File Operations (Import/Export)
* #### 6. Backup Data
* #### 7. Exit

Simply type the number corresponding to the action you want to perform and press Enter.

## Understanding the Data Files

To get you started without manually entering data, CCRM can import information from simple CSV (Comma-Separated Values) files located in the `/test-data` folder.

## Student Data (`students.csv`)
This file contains the records for each student.

### Format:  `ID,RegistrationNumber,FullName,Email,Status`

### Example:
```bash
Code snippet

S001,24BCE10001,Vindhya Agarwal,vindhya.a@vitbhopal.ac.in,ACTIVE
S002,24BCE10002,Prerna r,prerna.r@vitbhopal.ac.in,ACTIVE
S003,23BCI2001,Raj Sharma,raj.sharma@vitbhopal.ac.in,INACTIVE
```

## Course Data (`courses.csv`)
This file holds the details for each course offered.

### Format: `Code,Title,Credits,Instructor,Semester,Department`

### Example:
```bash
Code snippet

CSE101,Java Programming,4,Dr. Smith,FALL,CSE
MAT201,Linear Algebra,3,Dr. Jones,FALL,MATHEMATICS
```

## A Day in the Life: A Sample Workflow
Here’s a step-by-step walkthrough of how you might use the application in a typical session.

### Step 1: Import Initial Data
Start by populating the system. Navigate to **File Operations**  in the main menu and select the **Import Data** option. This will load all the students and courses from the CSV files.

### Step 2: Check If Everything Loaded
Head back to the main menu. Go into **Manage Students** and choose **List All Students**. Do the same for courses under **Manage Courses**. You should see all the records from your files.

### Step 3: Enroll a Student
Now for the fun part. Go to the **Manage Enrollment & Grades** menu. Select **Enroll Student**, then provide the ID of a student (e.g., `S001`) and the code of a course (e.g., `CSE1001`).

### Step 4: Record a Grade
After a student has been enrolled, you can assign them a grade. In the same menu, choose **Record Grades**. Enter the student's ID, the course code, and the marks they achieved. The system will automatically calculate the corresponding letter grade and grade points.

### Step 5: Generate a Transcript
To see a summary of a student's academic progress, go to the **Manage Students** menu and select the option to **Print Student Transcript**. Enter the student's ID, and a neatly formatted transcript will be displayed on the console.

### Step 6: Save Your Work
Before you finish, it's a good idea to save the current state of the system. Go to **File Operations** and select **Export Data**. This will write the latest student, course, and enrollment data to new files in the `/data` directory.

### Step 7: Create a Secure Backup
Finally, let's create a timestamped backup. From the main menu, select **Backup Data**. The application will copy your exported data into a new folder named with the current date and time, ensuring your records are safely archived.

And that's it! You've successfully managed records, graded a student, and backed up your data. Feel free to explore the other options and features.
