package com.sandor.lists.singlyLinkedList;

import com.sandor.Employee;

public class LinkedListMain {
    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        Employee jane = new Employee("Jane", "Jones", 123);
        Employee john = new Employee("John", "Doe", 4567);
        Employee mary = new Employee("Mary", "Smith", 22);
        Employee mike = new Employee("Mike", "Wilson", 3245);

        list.addToFront(jane);
        list.addToFront(john);
        list.addToFront(mary);
        list.addToFront(mike);

        list.printList();
        System.out.println("\n" + list.getSize());
        System.out.println(list.isEmpty());
        list.removeFromFront();
        list.printList();
        System.out.println("\n" + list.getSize());
    }
}
