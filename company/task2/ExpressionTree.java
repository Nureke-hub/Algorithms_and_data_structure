package com.company.task2;

public class ExpressionTree {
    private Node root;
    public ExpressionTree() { root = null; }
    public ExpressionTree(String math){
        this();
        solve(math);
    }
    public void solve(String math){root = Tree(0, math.length() -1 , root, math);}
    public void print(){ print(root); System.out.println();}
    public void calculate(){ System.out.println(calculation(root).getData()); }

    private Node Tree(int left, int right, Node root, String math){
        if (left == right) return new Node(Character.toString(math.charAt(left)), true);
        int index = Priority(left,right,math);
        root = new Node(Character.toString(math.charAt(index)));
        root.setRight(
                Tree(index + 1, right, root.getRight(), math)
        );
        root.setLeft(
                Tree(left, index -1, root.getLeft(),math)
        );
        return root;
    }
    private int Inferiority(int left, int right, String math) {
        for (int i=right; i >= left; i--)
            if (math.charAt(i) == 'x' || math.charAt(i) == '/')
                return i;
        return -1;
    }
    private int Priority(int left, int right, String math){
        for (int i=right; i >= left; i--)
            if (math.charAt(i) == '-' || math.charAt(i) == '+')
                return i;
        return Inferiority(left,right,math);
    }
    private void print(Node root){
        if (root != null){
            print(root.getLeft());
            System.out.printf(root.getData() +  " ");
            print(root.getRight());
        }
    }

    private Node calculation(Node root){
        if (!root.isDigit()){
            int result = operation(
                    calculation(root.getLeft()),
                    calculation(root.getRight()),
                    root.getData()
            );
            return new Node(String.valueOf(result));
        }
        return root;
    }

    private int operation(Node left, Node right, String expression){
        int l = Integer.parseInt(left.getData());
        int r = Integer.parseInt(right.getData());
        switch (expression){
            case "+":
                return l+r;
            case "-":
                return l-r;
            case "x":
                return l*r;
            case "/":
                return l/r;
            default:
                return 0;
        }
    }
}
