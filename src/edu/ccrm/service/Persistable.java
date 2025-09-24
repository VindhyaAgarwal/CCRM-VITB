package edu.ccrm.service;

public interface Persistable<T> {
    void saveToFile(String filename);
    T loadFromFile(String filename);
}