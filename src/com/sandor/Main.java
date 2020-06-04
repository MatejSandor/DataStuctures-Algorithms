package com.sandor;

import com.sandor.heaps.Heap;
import com.sandor.trees.Tree;

public class Main {
    public static void main(String[] args) {
        Tree intTree = new Tree();
        intTree.insert(25);
        intTree.insert(20);
        intTree.insert(15);
        intTree.insert(27);
        intTree.insert(30);
        intTree.insert(29);
        intTree.insert(26);
        intTree.insert(22);
        intTree.insert(32);

        intTree.inOrder();
        System.out.println();
//        System.out.println(intTree.get(27));
//        System.out.println(intTree.max());
//        System.out.println(intTree.min());
        intTree.delete(15);
        System.out.println();
        intTree.inOrder();
        intTree.delete(27);
        System.out.println();
        intTree.inOrder();
        intTree.delete(25);
        System.out.println();
        intTree.inOrder();

        Heap heap = new Heap(10);

        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        heap.printHeap();

        System.out.println(heap.peek());

        heap.delete(0);
        heap.printHeap();

        System.out.println(heap.peek());
    }

}
