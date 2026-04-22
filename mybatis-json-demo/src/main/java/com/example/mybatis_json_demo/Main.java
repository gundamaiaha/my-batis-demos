package com.example.mybatis_json_demo;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", "PASS"),
            new Student("Bob", "Technical Fail"),
            new Student("Charlie", "PASS with distinction"),
            new Student("David", "PASS"),
            new Student("Eva", "Fail due to attendance"),
            new Student("Frank", "PASS"),
            new Student("Grace", "Failed the exam")
        );

        // Step 1: Categorize into Pass and Fail based on the content of the status
        Map<String, Long> groupByStatus = students.stream()
            .collect(Collectors.groupingBy(student -> {
                if (student.getStatus().toUpperCase().contains("PASS")) {
                    return "Pass";
                } else if (student.getStatus().toUpperCase().contains("FAIL")) {
                    return "Fail";
                } else {
                    return "Unknown";
                }
            }, Collectors.counting()));

        // Step 2: Get total count of students
        long totalStudents = students.size();

        // Step 3: Calculate percentage for Pass and Fail
        Map<String, Double> percentageByStatus = groupByStatus.entrySet().stream()
            .filter(entry -> !entry.getKey().equals("Unknown"))
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> (entry.getValue() * 100.0) / totalStudents
            ));

        // Print the results
        percentageByStatus.forEach((status, percentage) ->
            System.out.println("Status: " + status + ", Percentage: " + percentage + "%"));
    }
}
