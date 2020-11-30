package com.company.task2;

public class Main {
    public static void main(String[] args) {
        ExpressionTree expressionTree = new ExpressionTree("4x3-6/2-5x3-1+9");
        expressionTree.print();
        expressionTree.calculate();
    }
    
}
