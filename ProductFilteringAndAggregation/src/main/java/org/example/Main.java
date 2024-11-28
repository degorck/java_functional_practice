package org.example;

import org.example.model.Product;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static java.util.stream.Collectors.groupingBy;

public class Main {
    public static void main(String[] args) {
        //Problem: Process a list of products in an e-commerce system.
        List<Product> products = List.of(
                new Product("Laptop", "Electronics", 1200, true),
                new Product("Phone", "Electronics", 800, false),
                new Product("Table", "Furniture", 300, true),
                new Product("PC", "Electronics", 250, true)
        );
        //Filter products that are in stock.
        Predicate<Product> productInStock = Product::isInStock;
        List<Product> productsInStock = products.stream()
                .filter(productInStock)
                .toList();
        //Get the top 3 most expensive products.
        Comparator<Product> moreExpensive = Comparator.comparing(Product::getPrice).reversed();
        List<Product> threeMoreExpensiveProducts = products.stream()
                .sorted(moreExpensive)
                .limit(3)
                .toList();
        //Calculate the total price of all products in stock.
        double totalPrice = products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
        //Create a map where the key is the category, and the value is a list of products in that category.
        Map<String, List<Product>> productsByCategory = products.stream()
                        .collect(groupingBy(Product::getCategory));
        System.out.println("Products in stock");
        System.out.println(productsInStock.toString());
        System.out.println("3 more expensive products");
        System.out.println(threeMoreExpensiveProducts.toString());
        System.out.println("The total price of all products is");
        System.out.println(totalPrice);
        System.out.println("The products by category are:");
        System.out.println(productsByCategory.toString());

    }
}