package org.example;

import org.example.model.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import static java.util.stream.Collectors.groupingBy;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", "HR", 60000),
                new Employee("Bob", "IT", 45000),
                new Employee("Bob", "Finance", 5000),
                new Employee("Charlie", "Finance", 75000),
                new Employee("Diana", "IT", 70000)
        );
        //Filter employees with a salary greater than 50,000.
        Predicate<Employee> greaterThanFiftyK = employee -> employee.getSalary() > 50000;
        List<Employee> employeesSalaryGreaterThanFiftyK = employees.stream()
                .filter(greaterThanFiftyK)
                .toList();
        //Group employees by department using Collectors.groupingBy.
        Map<String, List<Employee>> employeesByDepartment = employees.stream()
                .collect(groupingBy(Employee::getDepartment));
        //Count employees in each department.
        Predicate<Employee> employeeInIt = employee -> employee.getDepartment().equals("IT");
        Predicate<Employee> employeeInFinance = employee -> employee.getDepartment().equals("Finance");
        Predicate<Employee> employeeInHumanResources = employee -> employee.getDepartment().equals("HR");
        long employeesInIT = employees.stream()
                .filter(employeeInIt)
                        .count();
        long employeesInFinance = employees.stream()
                .filter(employeeInFinance)
                .count();
        long employeesInHumanResources = employees.stream()
                .filter(employeeInHumanResources)
                .count();
        //Sort employees by their names.
        Comparator<Employee> employeeSortedByName = Comparator.comparing(Employee::getName);
        List<Employee> sortedByName = employees.stream()
                .sorted(employeeSortedByName)
                        .toList();
        //Create a list of unique employee names.
        List<String> uniqueNameEmployees = employees.stream()
                .map(Employee::getName)
                .distinct()
                .toList();
        //Find the highest-paid employee using max.
        Employee highestPaidEmployee = employees.stream()
                        .max(Comparator.comparing(Employee::getSalary))
                        .orElseThrow(NoSuchElementException::new);

        System.out.println("Employees Salary Greater than 50000");
        System.out.println(employeesSalaryGreaterThanFiftyK.toString());
        System.out.println("Employees by Department");
        System.out.println(employeesByDepartment.toString());
        System.out.println("Employees in IT");
        System.out.println(employeesInIT);
        System.out.println("Employees in HR");
        System.out.println(employeesInHumanResources);
        System.out.println("Employees in Finance");
        System.out.println(employeesInFinance);
        System.out.println("Employees sorted by Name");
        System.out.println(sortedByName.toString());
        System.out.println("Employees with unique name");
        System.out.println(uniqueNameEmployees);
        System.out.println("High-paid employee");
        System.out.println(highestPaidEmployee.toString());

        
    }
}