package com.company.task2;

public class Node {
    private Node right;
    private Node left;
    private String data;
    private boolean isDigit = false;

    public Node(String data) { this.data = data; }
    public Node(String data, boolean isDigit) {this(data);this.isDigit = isDigit;}

    public Node getRight() { return right; }

    public void setRight(Node right) { this.right = right; }

    public Node getLeft() { return left; }

    public void setLeft(Node left) { this.left = left; }

    public String getData() { return data;}

    public void setData(String data) { this.data = data;}

    public boolean isDigit() { return isDigit;}

    public void setDigit(boolean digit) { isDigit = digit;}

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
