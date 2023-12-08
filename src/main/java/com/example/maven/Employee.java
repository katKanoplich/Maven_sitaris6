package com.example.maven;

public class Employee {
    private String id;
    private String name;
    private int age;
    private String speciality;
    private String category;
    private double salary;

    public Employee(){}

    public Employee(String id, String name, int age, String speciality, String category, double salary){
        this.id = id;
        this.name = name;
        this.age = age;
        this.speciality = speciality;
        this.category = category;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
