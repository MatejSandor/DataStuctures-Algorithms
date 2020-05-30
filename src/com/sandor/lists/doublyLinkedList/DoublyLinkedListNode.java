package com.sandor.lists.doublyLinkedList;

import com.sandor.lists.Employee;

public class DoublyLinkedListNode {
    private Employee employee;
    private DoublyLinkedListNode next;
    private  DoublyLinkedListNode previous;

    public DoublyLinkedListNode(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public DoublyLinkedListNode getNext() {
        return next;
    }

    public void setNext(DoublyLinkedListNode next) {
        this.next = next;
    }

    public DoublyLinkedListNode getPrevious() {
        return previous;
    }

    public void setPrevious(DoublyLinkedListNode previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return employee.toString();
    }
}
