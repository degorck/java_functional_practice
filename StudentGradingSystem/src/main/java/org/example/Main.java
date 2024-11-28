package org.example;

import org.example.model.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.function.DoubleConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("John", 85),
                new Student("Alice", 90),
                new Student("Bob", 75),
                new Student("Diana", 60)
        );
        //Problem: Process a list of students and their scores.
        //
        //Calculate the average score of all students.
        OptionalDouble average = students.stream()
                .mapToDouble(Student::getScore)
                        .average();




        if(average.isPresent()){
            System.out.println("Average");
            System.out.println(average.getAsDouble());
            //Find students who scored above the average.
            Predicate<Student> studentAboveAverage = student -> student.getScore() > average.getAsDouble();
            List<Student> studentsAboveAverage = students.stream()
                    .filter(studentAboveAverage)
                    .toList();
            System.out.println("Students above average: ");
            System.out.println(studentsAboveAverage.toString());
        }
        else {
            System.out.println("Unable to calculate average");
        }
        //Group students into grades (e.g., A, B, C) based on their scores.
        Map<String, List<Student>> studentsByGrade = students.stream()
                .collect(Collectors.groupingBy(
                        student -> {
                            double score = student.getScore();
                            if (score >= 90) return "A";
                            else if (score >= 80) return "B";
                            else if (score >= 70) return "C";
                            else return "D";
                        }
                ));
        studentsByGrade.forEach((grade, studentList) ->
                System.out.println("Grade " + grade + ": " + studentList));

        //Sort students by their scores in descending order.
        Comparator<Student> studentByGrade = Comparator.comparing(Student::getScore);
        System.out.println("Students sorted by score:");
        List<Student> studentsByScore = students.stream()
                .sorted(studentByGrade.reversed())
                .toList();
        System.out.println(studentsByScore);
    }
}