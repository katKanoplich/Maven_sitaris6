package com.example.maven;

import java.util.List;

public class Statistics {
    public int calculateNumberOfEmployees(List<Employee> employees){
        return employees.size();
    }

    public int averageAge(List<Employee> employees){
        int averageAge = 0;
        for(Employee employee: employees){
            averageAge += employee.getAge();
        }
        averageAge /= employees.size();
        return averageAge;
    }

    public double averageSalary(List<Employee> employees){
        double averageSalary = 0;
        for(Employee employee: employees){
            averageSalary += employee.getSalary();
        }
        averageSalary /= employees.size();
        return Math.round(averageSalary);
    }
}
