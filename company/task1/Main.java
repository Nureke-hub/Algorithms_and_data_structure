package com.company.task1;

import com.company.task1.BinarySearchTree;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BinarySearchTree<Integer> a = new BinarySearchTree<>();

        a.insert(4);
        a.insert(3);
        a.insert(2);
        a.insert(5);
        a.insert(7);
        a.insert(1);


        System.out.println(a.smallest());

        System.out.println(a.largest());
//        System.out.println(a.find(12));
//        a.delete(1);
//        a.delete(5);
        a.print();
    }
}
