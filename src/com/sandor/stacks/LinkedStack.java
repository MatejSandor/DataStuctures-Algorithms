package com.sandor.stacks;

import com.sandor.Employee;

import java.util.LinkedList;

public class LinkedStack {
    private LinkedList<Employee> stack;

    public LinkedStack(LinkedList<Employee> stack) {
        stack = new LinkedList<Employee>();
    }

    public void push(Employee employee) {
        stack.push(employee);
    }

    public Employee pop() {
        return stack.pop();
    }

    public Employee peek() {
        return stack.peek();
    }
}
