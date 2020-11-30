package com.company.Task1;

public class Student implements Comparable<Student>{
    private String name;
    private int age;
    private double gpa;

    public Student() {}

    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
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

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return name + " " +  age + " " + gpa;
    }

    @Override
    public int compareTo(Student s) {
        if(this.gpa == s.gpa){
            return 0;
        }else if(this.gpa > s.gpa){
            return 1;
        }else{
            return -1;
        }
    }
}
