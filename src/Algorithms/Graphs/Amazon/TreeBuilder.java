package Algorithms.Graphs.Amazon;

import java.util.Stack;

/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

 abstract class Node {
    public abstract int evaluate();
    // define your fields here
    public static Node from(String value) {
        switch (value) {
            case "+":
                return new additionOperator();
            case "-":
                return new subtractionOperator();
            case "*":
                return new multiplicationOperator();
            case "/":
                return new divisionOperator();
            default:
                return new Numeric(value);
        }
    }
};

abstract class Operator extends Node {
    Node left;
    Node right;

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

class additionOperator extends Operator {

    @Override
    public int evaluate() {
        return this.left.evaluate() + this.right.evaluate();
    }
}

class divisionOperator extends Operator {

    @Override
    public int evaluate() {
        return this.left.evaluate() / this.right.evaluate();
    }
}

class multiplicationOperator extends Operator {

    @Override
    public int evaluate() {
        return this.left.evaluate() * this.right.evaluate();
    }
}

class subtractionOperator extends Operator {

    @Override
    public int evaluate() {
        return this.left.evaluate() - this.right.evaluate();
    }
}

class Numeric extends Node {
    String value;
    public Numeric(String value) {
        this.value = value;
    }

    @Override
    public int evaluate() {
        return Integer.valueOf(this.value);
    }
}

/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input
 * and returns the expression tree represnting it as a Node.
 */

public class TreeBuilder {
    public int buildTree(String[] postfix) throws Exception {
        Stack<Node> stack = new Stack<>();
        for(String value: postfix){
            Node node = Node.from(value);

            if(node instanceof Numeric) {
                stack.push(node);
            }
            else if (node instanceof  Operator) {
                Operator op = (Operator) node;
                op.setLeft(stack.pop());
                op.setRight(stack.pop());
                stack.push(op);
            }
            else
                throw new Exception("node is neither numeric or operator");


        }
        return stack.pop().evaluate();
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */
