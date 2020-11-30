package com.company.task1;


public class BinarySearchTree<T extends Comparable<T>> {
    private Node root;

    BinarySearchTree(){ root = null; }

    public void insert(T data){ root = insert(data, root); }
    public void delete(T data){ root =  delete(root, data); }
    public boolean find(T data){ return find(root, data) != null; }
    public T smallest(){ return smallest(root); }
    public T largest(){ return largest(root); }
    public void print(){ print(root);}



    private Node insert(T data, Node root){
        if (root == null)
            root = new Node(data);

        if (root.getData().compareTo(data) < 0) // root < data(right) // ROOT --> DATA
            root.setRight(
                    insert(data, root.getRight())
            );
        else if(root.getData().compareTo(data) > 0) // root > data(left) // DATA <-- ROOT
            root.setLeft(
                    insert(data, root.getLeft())
            );
        return root;
    }
    private Node delete(Node root, T data){
        if (root != null) {
            if (root.getData().compareTo(data) < 0)
                root.setRight(
                        delete(root.getRight(), data)
                );
            else if (root.getData().compareTo(data) > 0)
                root.setLeft(
                        delete(root.getLeft(), data)
                );
            else {
                if (root.getLeft() == null)
                    return root.getRight();
                else if(root.getRight() == null)
                    return root.getLeft();

                root.setData(
                        minV(root)
                );

                root.setRight(
                        delete(root.getRight(), (T) root.getData())
                );
            }
        }
        return root;
    }
    private T minV(Node root){
        T minv = (T) root.getData();
        while (root.getLeft() != null){
            minv = (T) root.getLeft().getData();
            root = root.getLeft();
        }
        return minv;
    }
    private Node find(Node root, T data){
        if (root != null) {
            if (root.getData().compareTo(data) < 0)
                return find(root.getRight(), data);
            else if (root.getData().compareTo(data) > 0)
                return find(root.getLeft(), data);
            else
                return root;
        }
        return null;
    }
    private T smallest(Node root){
        if (root.getLeft() == null)
            return (T) root.getData();
        return smallest(root.getLeft());
    }
    private T largest(Node root){
        if (root.getRight() == null)
            return (T) root.getData();
        return largest(root.getRight());
    }
    private void print(Node root){
        if (root != null){
            print(root.getLeft());
            System.out.printf(root.getData() + " ");
            print(root.getRight());
        }
    }

    @Override
    public String toString() {
        String string = String.valueOf(root.getData());
        return string;
    }
}



