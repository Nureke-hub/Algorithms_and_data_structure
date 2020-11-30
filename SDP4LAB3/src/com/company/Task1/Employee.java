package com.company.Task1;

public class Employee implements Comparable<Employee>{
    private String name;
    private int salary;

    public Employee() {}

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " " +  salary;
    }

    public int compareTo(Employee e){
        if (this.salary == e.salary) {
            return 0;
        } else if (this.salary > e.salary){
            return 1;
        } else {
            return -1;
        }
    }

}
