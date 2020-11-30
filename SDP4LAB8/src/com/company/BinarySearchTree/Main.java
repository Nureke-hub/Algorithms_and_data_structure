package com.company.BinarySearchTree;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree<String> bst = new BinarySearchTree<>("C");
        bst.insert("B");
        bst.insert("S");
        bst.insert("E");
        bst.insert("D");
        bst.insert("A");

        bst.delete("C");
        bst.print();
    }
}
