package com.sandor.heaps;

public class Heap {
    private int[] heap;
    private int size;

    public Heap(int capacity) {
        heap = new int[capacity];
    }

    public void insert(int value) {
        if(isFull()) {
            throw new IndexOutOfBoundsException("Heap is full!");
        }

        heap[size] = value;
        fixHeapUp(size);
        size++;
    }

    private void fixHeapUp(int index) {
        int newValue = heap[index];
        while(index>0 && newValue>heap[getParent(index)]) {
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }
        heap[index] = newValue;
    }

    public int delete(int value) {
        return 0;
    }

    public boolean isFull() {
        return size == heap.length;
    }

    public int getParent(int index) {
        return (index-1)/2;
    }

    public boolean isEmpty() { return size == 0;}

    public int getChild(int index,boolean left) {
        if (left) {
            return (2*index)+1;
        } else return (2*index)+2;
    }
}
