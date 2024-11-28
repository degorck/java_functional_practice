package org.example.model;

public class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee (String name, String department, double salary){
        this.name = name;
        this.department = department;
        this.salary = salary;

    }

    public String setName(String name){
        this.name = name;
        return this.name;
    }

    public String setDepartment(String department){
        this.department = department;
        return this.department;
    }

    public double setSalary(double salary){
        this.salary = salary;
        return this.salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public String toString() {
        return "[Name: " + this.name + ", Department: " + this.department + ", Salary: " + this.salary + "]";
     }
}
