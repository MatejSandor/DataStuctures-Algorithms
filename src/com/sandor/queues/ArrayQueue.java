package com.sandor.queues;

import com.sandor.Employee;

public class ArrayQueue {
    private Employee[] queue;
    private int front;
    private int back;

    public ArrayQueue(int capacity) {
        queue = new Employee[capacity];
    }

    public int getSize() {
        return back;
    }

    public boolean isEmpty() {
        return back-front < 1;
    }

    public void enqueue(Employee employee) {

    }

    public void dequeue() {

    }

    public void peek() {

    }
}
