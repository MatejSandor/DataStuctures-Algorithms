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

    private void fixHeapBelow(int index, int lastHeapIndex) {
        int childToSwap;
        int newValue = heap[index];
        while(index<= lastHeapIndex) {
            int leftChild = getChild(index,true);
            int rightChild = getChild(index,false);
            if(leftChild <= lastHeapIndex) {
                if (rightChild > lastHeapIndex) {
                    childToSwap = leftChild;
                } else {
                    childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);
                }

                if(heap[index]<heap[childToSwap]) {
                    int tmp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = tmp;
                }
                else {
                    break;
                }
                index = childToSwap;
            }
            else {
                break;
            }
        }
    }

    public int delete(int index) {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }
        int parent = getParent(index);
        int deletedValue = heap[index];
        heap[index] = heap[size-1];
        if(index == 0 || heap[index] < heap[parent]) {
            fixHeapBelow(index,size-1);
        } else {
            fixHeapUp(index);
        }

        size--;
        return deletedValue;
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
