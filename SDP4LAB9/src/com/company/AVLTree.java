package com.company;

public class AVLTree<T> {
    private Node root;

    private int height(Node N) {
        if (N == null)
            return 0;
        return N.getHeight();
    }
    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    private Node rightRotate(Node y) {
        Node x = y.getLeft();
        Node T2 = x.getRight();

        x.setRight(y);
        y.setLeft(T2);

        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);

        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.getRight();
        Node T2 = y.getLeft();

        y.setLeft(x);
        x.setRight(T2);

        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);

        return y;
    }

    private int getBalance(Node N) {
        if (N == null)
            return 0;
        return height(N.getLeft()) - height(N.getRight());
    }

    public Node insert(Node node, int key) {
        if (node == null)
            return (new Node(key));
        if (key < node.getData())
            node.setLeft(insert(node.getLeft(), key));
        else if (key > node.getData())
            node.setRight(insert(node.getRight(), key));
        else
            return node;


        node.setHeight(1 + max(height(node.getLeft()), height(node.getRight())));

        int balance = getBalance(node);

        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && key < node.getLeft().getData())
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.getRight().getData())
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.getLeft().getData()) {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.getRight().getData()) {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }

        return node;
    }

    public void insert(int key){
        this.root = insert(root, key);
    }

    public void printLevelOrder(){
        int h = height(root);
        for (int i=1; i<=h; i++)
        {
            printGivenLevel(root, i);
            System.out.println();
        }
    }

    private void printGivenLevel(Node root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.println(root.getData());
        else if (level > 1)
        {
            printGivenLevel(root.getLeft(), level-1);
            printGivenLevel(root.getRight(), level-1);
        }
    }
}



//    public void delete(T data) {
//        this.root = deleteNode(root, data);
//        h--;
//    }
//    private Node deleteNode(Node root, T data) {
//        if(root == null) return null;
//        if(root.getData().compareTo(data) > 0) {
//            root.setLeft(deleteNode(root.getLeft(), data));
//        } else if(root.getData().compareTo(data) < 0) {
//            root.setRight(deleteNode(root.getRight(), data));
//        } else {
//            if(root.getLeft() == null && root.getRight() == null) {
//                return null;
//            } else if(root.getLeft() == null) {
//                return root.getRight();
//            } else if(root.getRight() == null) {
//                return root.getLeft();
//            } else {
//                T minValue = minValue(root.getRight());
//                root.setData((Comparable) minValue);
//                root.setRight(deleteNode(root.getRight(), minValue));
//            }
//        }
//        return root;
//    }
//    private T minValue(Node node) {
//        if(node.getLeft() != null) {
//            return minValue(node.getLeft());
//        }
//        return (T) node.getData();
//    }
