package com.sandor.lists.singlyLinkedList;

import com.sandor.lists.Employee;

public class LinkedList {
    private LinkedListNode head;
    private int size;

    public void addToFront(Employee employee) {
        LinkedListNode node = new LinkedListNode(employee);
        node.setNext(head);
        head = node;
        size++;
    }

    public LinkedListNode removeFromFront() {
        if(isEmpty()) {
            return null;
        }
        LinkedListNode removedNode = head;
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        LinkedListNode current = head;
        System.out.print("Head -> ");

        while(current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.print("null");
    }
}
