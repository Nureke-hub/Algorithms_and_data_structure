package com.company.Task2;
import java.util.Iterator;

public class Main {
    public static void main(String args[]){
        DoubleLinkedList<String> dll = new DoubleLinkedList<>();
        dll.add("Nurdan", true);
        dll.add("Akzhol", false);
        dll.add("Zamanbek", false);
        dll.add("Bota", false);
        dll.add("Diana", false);
        dll.add("Talshyn", false);
        System.out.println(dll);

        ListIterator<String> l = new ListIterator<>(dll, true);
        while (l.hasNext()){
            System.out.println(l.next());
        }


//		while (it.hasNext()){
//			System.out.println(it.next());
//		}

//        for (Student s : students){
//            System.out.println(s);
//        }
    }
}
