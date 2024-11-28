package org.example;

import org.example.model.Book;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Problem: Process a catalog of books.

        List<Book> books = List.of(
                new Book("Book1", "Author1", "Fiction", 10.99, 2021),
                new Book("Book2", "Author2", "Non-Fiction", 15.99, 2022),
                new Book("Book3", "Author1", "Fiction", 12.99, 2023)
        );
        //Find all books written by a specific author.
        Predicate<Book> bookByAuthor = book -> book.getAuthor().equals("Author1");
        List<Book> booksByAuthor = books.stream()
                .filter(bookByAuthor)
                .toList();
        System.out.println(booksByAuthor.toString());
        //Sort books by their publication year.
        Comparator<Book> sortedByPublicationYear = Comparator.comparing(Book::getYear);
        System.out.println("Books sorted by publication year: ");
        List<Book> booksSortedByPublicationYear = books.stream()
                .sorted(sortedByPublicationYear)
                .toList();
        System.out.println(booksSortedByPublicationYear);
        //Group books by genre.
        System.out.println("Books by genre: ");
        Map<String, List<Book>> booksByGenre = books.stream()
                .collect(Collectors.groupingBy(Book::getGenre));
        booksByGenre.forEach((genre, bookList) ->
                System.out.println("Genre: " + genre + ": " + bookList));
        //Create a map where the key is the genre, and the value is the average price of books in that genre.

        Map<String, Double> averagePriceByGenre = books.stream()
                .collect(Collectors.groupingBy(Book::getGenre, Collectors.averagingDouble(Book::getPrice)));
        System.out.println("Average price by genre: ");
        System.out.println(averagePriceByGenre);
        //Find the most expensive book in each genre.
        booksByGenre.forEach((genre, bookList) ->
                System.out.println("Genre: " + genre + ": " + bookList.stream()
                        .max(Comparator.comparingDouble(Book::getPrice))));


    }
}