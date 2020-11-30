package com.company.ExpressionTree;

public class ExpressionTree {
    private NodeE root = null;
    private char[] expression = null;
    private double ans = 0;

    public  ExpressionTree(String str) { this.expression = str.toCharArray(); }
    private int operatorTree(char[] expression, int low, int high, char op1, char op2){
        while (low != high){
            if (expression[high] == op1 || expression[high] == op2)
                return high;
            high--;
        }
        return -1;
    }

    private NodeE divisionMultiplication(int low, int high){
        NodeE md = new NodeE(expression[low] - 48);
        int p = operatorTree(expression, low, high, '*', '/');
        if(p != -1){
            md = new NodeE(expression[p]);
            md.setRight(new NodeE(expression[p+1] - 48));
            md.setLeft(divisionMultiplication(low, p-1));
        }
        return md;
    }
    private NodeE answer(NodeE root, char[] expression, int low, int high){
        int p = operatorTree(expression, low, high, '+', '-');
        if (p != -1) {
            root = new NodeE(expression[p]);
            root.setRight(divisionMultiplication(p + 1, high));
            root.setLeft(answer(root.getLeft(), expression, low, p -1));
        }else {
            root = divisionMultiplication(low, high);
        }
        return root;
    }
    public double sum(NodeE root){
        if(root != null){
            double x = sum(root.getLeft());
            if(root.isNumber()){
                return root.getNumber();
            }else if (root.getOperand() == '+'){
                return x += sum(root.getRight());
            }else if(root.getOperand() == '-'){
                return x -= sum(root.getRight());
            }else if(root.getOperand() == '*'){
                return x *= sum(root.getRight());
            }else if(root.getOperand() == '/'){
                return x /= sum(root.getRight());
            }
        }
        return 0;
    }

    public double answer() {
        root = answer(root, expression, 0, expression.length - 1);
        return sum(root);
    }

    public void print (){
        print(root);
    }
    private void print(NodeE root){
        if(root != null){
            print(root.getLeft());
            System.out.print(root);
            print(root.getRight());
        }
    }
}