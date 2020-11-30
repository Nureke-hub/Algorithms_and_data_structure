package com.company.Task3;

import java.util.ArrayList;

public class Main {
    public static void main(String args[]){
        SortedLinkedList<String> list = new SortedLinkedList<>();
        list.addSorted("Addd");
        System.out.println(list);
        list.addSorted("Adde");
        System.out.println(list);
        list.addSorted("Aaaa");
        System.out.println(list);
        list.addSorted("Aaab");
        System.out.println(list);
        list.addSorted("Aabb");
        System.out.println(list);
        list.addSorted("Abbb");
        System.out.println(list);
        list.addSorted("Bbbb");
        System.out.println(list);
        list.addSorted("Z");
        System.out.println(list);
        list.addSorted("Asdkjfbs");
        System.out.println(list);

        list.remove(2);
        System.out.println(list);
    }
}
