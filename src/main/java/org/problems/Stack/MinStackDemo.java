package org.problems.Stack;

import java.util.Stack;

public class MinStackDemo {

    public static void main(String[] args) {

        MinStack minStack = new MinStack();

        // Sample input operations
        minStack.push(5);
        minStack.push(3);
        minStack.push(7);
        minStack.push(3);

        System.out.println("Top element: " + minStack.top());     // 3
        System.out.println("Minimum: " + minStack.getMin());      // 3

        minStack.pop(); // removes 3

        System.out.println("Top element: " + minStack.top());     // 7
        System.out.println("Minimum: " + minStack.getMin());      // 3

        minStack.pop(); // removes 7

        System.out.println("Top element: " + minStack.top());     // 3
        System.out.println("Minimum: " + minStack.getMin());      // 3

        minStack.pop(); // removes 3

        System.out.println("Top element: " + minStack.top());     // 5
        System.out.println("Minimum: " + minStack.getMin());      // 5
    }
}

// Time : O(1)
// Space : O(n)

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;


    public MinStack() {
        stack = new Stack<>();
        minStack= new Stack<>();
    }

    public void push(int val) {

        stack.push(val);

        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
    }

    public void pop() {
        int popedVal = stack.pop();

        if(popedVal == minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {

        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
