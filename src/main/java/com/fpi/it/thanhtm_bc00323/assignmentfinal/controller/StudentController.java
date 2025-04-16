package com.fpi.it.thanhtm_bc00323.assignmentfinal.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.fpi.it.thanhtm_bc00323.assignmentfinal.model.Student;
import com.fpi.it.thanhtm_bc00323.assignmentfinal.utils.StudentUtils;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;

public class StudentController {

    private Map<String, Student> students;
    private DefaultTableModel model;

    public StudentController(Map<String, Student> students, DefaultTableModel model) {
        this.students = students;
        this.model = model;
    }

    public StudentController() {
        this.students = new HashMap<>();
        this.model = new DefaultTableModel(new String[]{"ID", "Name", "Course", "Major", "Class", "Average Score", "Rank"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    public void addStudent(String id, String name, String course, String major, String className,
            String subject1, double grade1, String subject2, double grade2, String subject3, double grade3) {
        if (students.containsKey(id)) {
            JOptionPane.showMessageDialog(null, "Student ID already exists!");
            return;
        }

        Student student = new Student(id, name, course, major, className);
        student.addSubjectScore(subject1, grade1);
        student.addSubjectScore(subject2, grade2);
        student.addSubjectScore(subject3, grade3);

        students.put(id, student);
        loadTableData();

    }

    public void editStudent(String id, String name, String course, String major, String className,
            String subject1, double grade1, String subject2, double grade2, String subject3, double grade3) {
        Student student = students.get(id);
        if (student != null) {
            student.setName(name);
            student.setCourse(course);
            student.setMajor(major);
            student.setClassName(className);

            student.addSubjectScore(subject1, grade1);
            student.addSubjectScore(subject2, grade2);
            student.addSubjectScore(subject3, grade3);

            loadTableData();
        }
    }

    public void deleteStudent(String id) {
        students.remove(id);
        loadTableData();
    }

    public void searchStudents(String keyword) {
        model.setRowCount(0);

        keyword = keyword.trim().toLowerCase();

        for (Student student : students.values()) {
            double avg = student.getAverageScore();
            String rank = StudentUtils.getRank(avg);

            if (student.getId().toLowerCase().contains(keyword)
                    || student.getName().toLowerCase().contains(keyword)
                    || student.getCourse().toLowerCase().contains(keyword)
                    || student.getMajor().toLowerCase().contains(keyword)
                    || student.getClassName().toLowerCase().contains(keyword)
                    || rank.toLowerCase().contains(keyword)) {

                model.addRow(new Object[]{
                    student.getId(),
                    student.getName(),
                    student.getCourse(),
                    student.getMajor(),
                    student.getClassName(),
                    String.format("%.2f", avg),
                    rank
                });
            }
        }
    }

    public void loadTableData() {
        model.setRowCount(0);
        for (Student student : students.values()) {
            double avgScore = student.getAverageScore();
            model.addRow(new Object[]{
                student.getId(),
                student.getName(),
                student.getCourse(),
                student.getMajor(),
                student.getClassName(),
                String.format("%.2f", avgScore),
                StudentUtils.getRank(avgScore)
            });
        }
    }

    public void loadStudentsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.dat"))) {
            students = (Map<String, Student>) ois.readObject();
            loadTableData(); // reloads the table view from map
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error loading students: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void saveStudentsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.dat"))) {
            oos.writeObject(students);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Error saving students: " + e.getMessage(),
                    "Save Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
