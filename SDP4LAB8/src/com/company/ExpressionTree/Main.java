package com.company.ExpressionTree;

public class Main {
    public static void main(String args[]){
        ExpressionTree x = new ExpressionTree("5+3*6/2-2");
        ExpressionTree y = new ExpressionTree("4/3-1+5*2");
        System.out.println(x.answer());
        x.print();
    }
}
