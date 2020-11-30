package com.company.task1;

class Node<T extends Comparable<T>>{
    private Node left;
    private Node right;
    private T data;

    public Node(T data) {
        this.data = data;
    }

    public Node(Node node){
        this.left = node.getLeft();
        this.right = node.getRight();
        this.data = (T) node.getData();
    }


    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


//    @Override
//    public int compareTo(T o){ return (data.compareTo(o) < 0) ? -1 : ((data.compareTo(o) > 0) ? 1 : 0); }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}