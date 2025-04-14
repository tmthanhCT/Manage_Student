/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpi.it.thanhtm_bc00323.assignmentfinal.controller;

import com.fpi.it.thanhtm_bc00323.assignmentfinal.model.Student;
import com.fpi.it.thanhtm_bc00323.assignmentfinal.utils.StudentUtils;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class SortController {

    public static void sortStudents(String sortBy, Map<String, Student> students, DefaultTableModel model) {
        List<Student> list = new ArrayList<>(students.values());
        mergeSort(list, sortBy);

        model.setRowCount(0);
        for (Student s : list) {
            model.addRow(new Object[]{
                s.getId(),
                s.getName(),
                s.getCourse(),
                s.getMajor(),
                s.getClassName(),
                String.format("%.2f", s.getAverageScore()),
                StudentUtils.getRank(s.getAverageScore())
            });
        }
    }

    private static void mergeSort(List<Student> list, String sortBy) {
        if (list.size() <= 1) {
            return;
        }

        int mid = list.size() / 2;
        List<Student> left = new ArrayList<>(list.subList(0, mid));
        List<Student> right = new ArrayList<>(list.subList(mid, list.size()));

        mergeSort(left, sortBy);
        mergeSort(right, sortBy);

        merge(list, left, right, sortBy);
    }

    private static void merge(List<Student> result, List<Student> left, List<Student> right, String sortBy) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            boolean takeLeft = compare(left.get(i), right.get(j), sortBy);
            result.set(k++, takeLeft ? left.get(i++) : right.get(j++));
        }

        while (i < left.size()) {
            result.set(k++, left.get(i++));
        }
        while (j < right.size()) {
            result.set(k++, right.get(j++));
        }
    }

    private static boolean compare(Student s1, Student s2, String sortBy) {
        return switch (sortBy) {
            case "Ascending name" ->
                s1.getName().compareToIgnoreCase(s2.getName()) <= 0;
            case "Descending name" ->
                s1.getName().compareToIgnoreCase(s2.getName()) > 0;
            case "Average score ascending" ->
                s1.getAverageScore() <= s2.getAverageScore();
            case "Average score descending" ->
                s1.getAverageScore() > s2.getAverageScore();
            default ->
                true;
        };
    }
}
