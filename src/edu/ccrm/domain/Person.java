package edu.ccrm.domain;

import java.time.LocalDateTime;

public abstract class Person {
    protected String id;
    protected String fullName;
    protected String email;
    protected boolean active;
    protected LocalDateTime createdAt;

    public Person(String id, String fullName, String email) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.active = true;
        this.createdAt = LocalDateTime.now();
    }
    public abstract String getDisplayInfo();
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public LocalDateTime getCreatedAt() { return createdAt; }

    @Override
    public String toString() {
        return String.format("ID: %s, Name: %s, Email: %s, Active: %s", 
                           id, fullName, email, active);
    }
}