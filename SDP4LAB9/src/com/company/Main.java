package com.company;

public class Main {

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        tree.printLevelOrder();

        /*
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */


    }
}
