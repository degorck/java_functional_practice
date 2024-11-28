package org.example;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //Problem: Count the frequency of words in a given paragraph.
        //Tokenize a paragraph into individual words.
        //Convert all words to lowercase.
        //Use a stream to create a map where the key is the word, and the value is the frequency.
        //Find the most common word.
        String paragraph = "Java streams are amazing. Streams allow functional programming in Java.";
        String delimiter = " ";
        UnaryOperator<String> stringToLowerCase = s -> s.replaceAll("[^a-zA-Z]", "").toLowerCase();
        List<String> convertedCountriesList = Stream.of(paragraph.split(delimiter, -1))
                .map(stringToLowerCase)
                        .toList();
        Map<String, Long> wordsFrequency = convertedCountriesList.stream()
                        .collect(Collectors.groupingBy(word -> word, Collectors.counting()
                        ));

        Optional<Map.Entry<String, Long>> mostRepeated = wordsFrequency.entrySet().stream()
                .max(Map.Entry.comparingByValue());
        mostRepeated.ifPresent(entry ->
                System.out.println("Most repeated word: " + entry.getKey() + " with frequency " + entry.getValue()));
    }
}