package com.sandor.lists.doublyLinkedList;

import com.sandor.Employee;

public class DoublyLinkedList {
    private DoublyLinkedListNode head;
    private DoublyLinkedListNode tail;
    private int size;

    public void addToFront(Employee employee) {
        DoublyLinkedListNode node = new DoublyLinkedListNode(employee);
        node.setNext(head);

        if (isEmpty()) {
            tail = node;
        } else {
            head.setPrevious(node);
        }

        head = node;
        size++;
    }

    public void addToEnd(Employee employee) {
        DoublyLinkedListNode node = new DoublyLinkedListNode(employee);

        if (isEmpty()) {
            head = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
        }

        tail = node;
        size++;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public DoublyLinkedListNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        DoublyLinkedListNode removedNode = head;

        if (head.getNext() == null) {
            tail = null;
        } else {
            head.getNext().setPrevious(null);
        }
        head = head.getNext();
        size--;
        removedNode.setNext(null);

        return removedNode;
    }

    public DoublyLinkedListNode removeFromEnd() {
        if (isEmpty()) {
            return null;
        }
        DoublyLinkedListNode removedNode = tail;

        if (tail.getPrevious() == null) {
            head = null;
        } else {
            tail.getPrevious().setNext(null);
        }

        tail = tail.getPrevious();
        size--;

        return removedNode;
    }

    public void printList() {
        DoublyLinkedListNode current = head;
        System.out.print("Head -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" <=> ");
            current = current.getNext();
        }

        System.out.println("null");
    }

}
