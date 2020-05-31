package com.sandor.lists.singlyLinkedList;

import com.sandor.Employee;

public class LinkedListNode {
    private Employee employee;
    private LinkedListNode next;

    public LinkedListNode(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return employee.toString();
    }
}
