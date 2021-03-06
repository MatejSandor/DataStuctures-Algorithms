package com.sandor.queues;

import com.sandor.Employee;

import java.util.NoSuchElementException;

public class ArrayQueue {
    private Employee[] queue;
    private int front;
    private int back;

    public ArrayQueue(int capacity) {
        queue = new Employee[capacity];
    }

    public int getSize() {
        return back - front;
    }

    public boolean isEmpty() {
        return back - front == 0;
    }

    private void enqueue(Employee employee) {
        if (back == queue.length - 1) {
            Employee[] newArray = new Employee[2 * queue.length];
            System.arraycopy(queue, 0, newArray, 0, queue.length);
            queue = newArray;
        }

        queue[back++] = employee;

    }

    public Employee dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Employee employee = queue[front];
        queue[front++] = null;

        if (getSize() == 0) {
            front = 0;
            back = 0;
        }

        return employee;
    }

    public Employee peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue[front];
    }

    public void printQueue() {
        for (int i = front; i < back; i++) {
            System.out.println(queue[i]);
        }
    }
}
