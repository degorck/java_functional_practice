package org.example.model;

public class Product {
    private String name;
    private String category;
    private double price;
    private boolean inStock;

    public Product(String name, String category, double price, boolean inStock){
        this.name = name;
        this.category = category;
        this.price = price;
        this.inStock = inStock;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public boolean isInStock() {
        return inStock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", inStock=" + inStock +
                '}';
    }
}
