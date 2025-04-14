/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpi.it.thanhtm_bc00323.assignmentfinal.service;

import java.util.*;

public class ScoreManager {

    private Map<String, List<Double>> scoreMap = new HashMap<>();

    public void addScore(String key, double score) {
        scoreMap.put(key, List.of(score));
    }

    public Map<String, List<Double>> getAllScores() {
        return scoreMap;
    }

    public void removeScoresForStudent(String studentKeyPrefix) {
        scoreMap.keySet().removeIf(key -> key.startsWith(studentKeyPrefix));
    }
}
