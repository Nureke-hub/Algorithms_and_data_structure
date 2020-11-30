package com.company.BinarySearchTree;

public class BinarySearchTree<T> {
    private Node root = null;

    public BinarySearchTree(Node root) {
        this.root = root;
    }
    public BinarySearchTree(T data) {
        this.root = new Node((Comparable) data);
    }

    public T smallest(){
        return smallest(root);
    }
    private T smallest(Node root){
        if(root.getLeft() == null){
            return (T)root.getData();
        }else return smallest(root.getLeft());
    }

    public T largest(){
        return largest(root);
    }
    private T largest(Node root){
        if(root.getRight() == null){
            return (T)root.getData();
        }else return largest(root.getRight());
    }

    public void insert(T obj){
        if(root == null){
            root = new Node((Comparable) obj);
        }else{
            insert(obj, root);
        }
    }
    private void insert(T data, Node root){
        if(root.getData().compareTo(data) >= 0){
            if(root.getLeft() != null){
                insert(data, root.getLeft());
            }else{
                root.setLeft(new Node((Comparable) data));
            }
        }else if (root.getData().compareTo(data) < 0){
            if(root.getRight() != null){
                insert(data, root.getRight());
            }else{
                root.setRight(new Node((Comparable) data));
            }
        }
    }

    public void print (){
        print(root);
    }
    private void print(Node root){
        if(root != null){
            print(root.getLeft());
            System.out.println(root.getData());
            print(root.getRight());
        }
    }

    public Node find(T obj){
        return find(obj, root);
    }
    private Node find(T obj, Node root){
        if(root != null){
            if (root.getData().compareTo(obj) == 0){
                return root;
            }else if(root.getData().compareTo(obj) > 0){
                return find(obj, root.getLeft());
            }else if (root.getData().compareTo(obj) < 0){
                return find(obj, root.getRight());
            }
        }
        return null;
    }

    public void delete(T data) {
        this.root = deleteNode(root, data);
    }
    private Node deleteNode(Node root, T data) {
        if(root == null) return null;
        if(root.getData().compareTo(data) > 0) {
            root.setLeft(deleteNode(root.getLeft(), data));
        } else if(root.getData().compareTo(data) < 0) {
            root.setRight(deleteNode(root.getRight(), data));
        } else {
            if(root.getLeft() == null && root.getRight() == null) {
                return null;
            } else if(root.getLeft() == null) {
                return root.getRight();
            } else if(root.getRight() == null) {
                return root.getLeft();
            } else {
                T minValue = minValue(root.getRight());
                root.setData((Comparable) minValue);
                root.setRight(deleteNode(root.getRight(), minValue));
            }
        }
        return root;
    }
    private T minValue(Node node) {
        if(node.getLeft() != null) {
            return minValue(node.getLeft());
        }
        return (T) node.getData();
    }
}