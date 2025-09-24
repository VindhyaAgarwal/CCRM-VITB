package edu.ccrm.domain;

public abstract class Instructor extends Person {
    private String department;
    private String employeeId;
    
    public Instructor(String id, String fullName, String email, String employeeId, String department) {
        super(id, fullName, email);
        this.employeeId = employeeId;
        this.department = department;
    }
    
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    
    public String getRole() {
        return "Instructor";
    }
    
    @Override
    public String toString() {
        return String.format("Instructor[ID: %s, Name: %s, Dept: %s]", 
                           getId(), getFullName(), department);
    }
}