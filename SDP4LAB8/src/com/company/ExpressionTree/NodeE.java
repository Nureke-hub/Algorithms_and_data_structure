package com.company.ExpressionTree;

public class NodeE {
    private char operand;
    private double number;
    private boolean isNumber = false;
    private NodeE left = null;
    private NodeE right = null;

    public NodeE (char operand){
        this.operand = operand;
    }

    public NodeE (double number){
        this.number = number;
        isNumber = true;
    }

    public boolean isNumber() {
        return isNumber;
    }

    public double getNumber() {
        return number;
    }

    public NodeE getLeft() {
        return left;
    }

    public void setLeft(NodeE left) {
        this.left = left;
    }

    public NodeE getRight() {
        return right;
    }

    public void setRight(NodeE right) {
        this.right = right;
    }

    public char getOperand() {
        return operand;
    }

    public void setOperand(char operand) {
        this.operand = operand;
    }

    @Override
    public String toString() {
        String s = "";
        if (isNumber){
            return Double.toString(number);
        }
        return  s + operand;
    }
}
