package com.sandor.queues;

import com.sandor.Employee;

import java.util.NoSuchElementException;

public class CircularQueue {
    private Employee[] queue;
    private int front;
    private int back;

    public CircularQueue(int capacity) {
        queue = new Employee[capacity];
    }

    public int getSize() {
        if(back >= front) {
            return back-front;
        } else {
            return back-front+queue.length;
        }
    }

    public boolean isEmpty() {
        return back-front == 0;
    }

    public void enqueue(Employee employee) {
        if(getSize() == queue.length - 1) {
            int numItems = getSize();
            Employee[] newArray = new Employee[2*queue.length];
            System.arraycopy(queue,front,newArray,0,queue.length-front);
            System.arraycopy(queue,0,newArray,queue.length-front,back);
            queue = newArray;

            front = 0;
            back = numItems;
        }

        queue[back] = employee;

        if(back < queue.length - 1) {
            back++;
        } else {
            back = 0;
        }

    }

    public Employee dequeue() {
        if(isEmpty()) {
            System.out.println("");
            throw new NoSuchElementException();
        }

        Employee employee = queue[front];
        queue[front++] = null;

        if(getSize() == 0) {
            front = 0;
            back = 0;
        } else if(front == queue.length) {
            front = 0;
        }

        return employee;
    }

    public Employee peek() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue[front];
    }

    public void printQueue() {
        if(back >= front) {
            for (int i = front; i < back; i++) {
                System.out.println(queue[i]);
            }
        } else {
            for(int i = front; i < queue.length; i++) {
                System.out.println(queue[i]);
            }
            for(int j = 0; j < back; j++) {
                System.out.println(queue[j]);
            }
        }
    }
}
