package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 12, 19, 3, 8, 7, 20, 4);
        //find even numbers
        Predicate<Integer> isEven = number -> number % 2 == 0;

        // Use Streams to filter even numbers
        List<Integer> evenNumbers = numbers.stream()
                .filter(isEven)
                .toList();

        //find greater numbers than 10
        Predicate<Integer> greaterThanTen = number -> number > 10;
        Comparator<Integer> descendingComparator = (a, b) -> b - a;
        List<Integer> numbersGreaterThanTen = numbers.stream()
                        .filter(greaterThanTen)
                        .sorted(descendingComparator)
                        .toList();
        //Calculate the sum of all numbers
        BinaryOperator<Integer> sum = Integer::sum;
        List<Integer> sumAllNumbers = numbers.stream()
                        .reduce(sum).stream().toList();

        //All numbers to string
        Function<Integer, String> integerToString = number -> "Number: " + number.toString();
        List<String> numbersToString = numbers.stream()
                        .map(integerToString)
                .toList();

        System.out.println("Even numbers: ");
        System.out.println(evenNumbers.toString());
        System.out.println("Numbers greater than 10: ");
        System.out.println(numbersGreaterThanTen.toString());
        System.out.println("The sum of all numbers is: ");
        System.out.println(sumAllNumbers.toString());
        System.out.println("The numbers to string list is:");
        System.out.println(numbersToString.toString());

    }
}