package com.company.Task1;

public class Main {

    public static void main(String[] args) {
        Array<Employee> employeeArray = new Array<>(10);
        employeeArray.add(new Employee("Nurdan", 982576));
        employeeArray.add(new Employee("Akzhol", 928576));
        employeeArray.add(new Employee("Zamanbek", 256894));
        employeeArray.add(new Employee("Bota", 560000));
        employeeArray.add(new Employee("Diana", 428880));
        employeeArray.add(new Employee("Tima", 2083434));
        employeeArray.add(new Employee("Asem", 65436));
        employeeArray.add(new Employee("Talshyn", 35462));
        employeeArray.add(new Employee("Sultan", 98576));
        employeeArray.add(new Employee("Yessimkhan", 85769));
        employeeArray.add(new Employee("Zhalgas", 256895));
        System.out.println("Students added successful");

        System.out.println(employeeArray);
        System.out.println();

        System.out.println(employeeArray.size());
        System.out.println();

        System.out.println(employeeArray.get(5));
        System.out.println();

        employeeArray.remove(5);
        System.out.println(employeeArray);
        System.out.println();

        employeeArray.sort();
        System.out.println(employeeArray);



//        Array<Student> students = new Array<>(10);
//        students.add(new Student("Nurdan", 19, 2.49));
//        students.add(new Student("Akzhol", 19, 3.45));
//        students.add(new Student("Zamanbek", 18, 3.45));
//        students.add(new Student("Bota", 19, 3.4));
//        students.add(new Student("Diana", 19, 3.0));
//        students.add(new Student("Tima", 19, 2.66));
//        students.add(new Student("Asem", 19, 3.1));
//        students.add(new Student("Talshyn", 19, 3.33));
//        students.add(new Student("Sultan", 19, 2.33));
//        students.add(new Student("Yessimkhan", 18, 2.0));
//        students.add(new Student("Zhalgas", 19, 3.73));
//        System.out.println("Students added successful");
//
//        System.out.println(students);
//        System.out.println();
//
//        System.out.println(students.size());
//        System.out.println();
//
//        System.out.println(students.get(5));
//        System.out.println();
//
//        students.remove(5);
//        System.out.println(students);
//        System.out.println();
//
//        students.sort();
//        System.out.println(students);
    }
}
