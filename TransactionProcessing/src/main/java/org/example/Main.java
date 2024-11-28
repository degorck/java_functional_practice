package org.example;

import org.example.model.Transaction;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //Problem: Analyze transactions in a banking system.
        List<Transaction> transactions = List.of(
            new Transaction(2024, "credit", "Alice", 1000),
            new Transaction(2024, "debit", "Bob", 500),
            new Transaction(2023, "credit", "Alice", 2000)
        );

        //Find all transactions in 2024 and sort them by amount.
        Predicate<Transaction> transactionIn2024 = transaction -> transaction.getYear() == 2024;
        List<Transaction> transactionsIn2024 = transactions.stream()
            .filter(transactionIn2024)
            .toList();
        System.out.println("Transactions in 2024: ");
        System.out.println(transactionsIn2024.toString());
        //Calculate the total value of transactions for each customer.
        System.out.println("Total value of transactions by customer: ");
        Map<String, Double> transactionByCustomer = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getCustomerName, Collectors.summingDouble(Transaction::getAmount)));
        System.out.println(transactionByCustomer.toString());
        //Identify the top spender.
        Map.Entry<String, Double> highestBuyer = transactionByCustomer.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);
        if (highestBuyer != null) {
            System.out.println("Highest Buyer: " + highestBuyer.getKey() + " with total: " + highestBuyer.getValue());
        } else {
            System.out.println("No transactions found.");
        }
        //Group transactions by type (e.g., credit, debit).
        Map<String, List<Transaction>> transactionByType = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getType));
        transactionByType.forEach((type, transactionList)->
                System.out.println("Transaction type: " + type + ": " + transactionList));

    }
}