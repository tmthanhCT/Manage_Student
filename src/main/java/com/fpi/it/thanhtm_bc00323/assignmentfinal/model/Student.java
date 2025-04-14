
package com.fpi.it.thanhtm_bc00323.assignmentfinal.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String id;
    private String name;
    private String course;
    private String major;
    private String className;
    private Map<String, Double> subjectScores;
    
    public Student(String id, String name, String course, String major, String className) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.major = major;
        this.className = className;
        this.subjectScores = new HashMap<>();
    }

    public void addSubjectScore(String subject, double score) {
        subjectScores.put(subject, score);
    }

    public double getSubjectScore(String subject) {
        return subjectScores.getOrDefault(subject, 0.0);
    }

    public double getAverageScore() {
        if (subjectScores.isEmpty()) {
            return 0.0;
        }
        double sum = subjectScores.values().stream().mapToDouble(Double::doubleValue).sum();
        return sum / subjectScores.size();
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Map<String, Double> getSubjectScores() {
        return subjectScores;
    }

    public void setSubjectScores(Map<String, Double> subjectScores) {
        this.subjectScores = subjectScores;
    }
}
