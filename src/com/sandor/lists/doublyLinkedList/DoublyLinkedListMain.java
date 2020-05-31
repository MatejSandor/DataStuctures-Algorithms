package com.sandor.lists.doublyLinkedList;

import com.sandor.Employee;

public class DoublyLinkedListMain {
    public static void main(String[] args) {
        Employee jane = new Employee("Jane", "Jones", 123);
        Employee john = new Employee("John", "Doe", 4567);
        Employee mary = new Employee("Mary", "Smith", 22);
        Employee mike = new Employee("Mike", "Wilson", 3245);

        DoublyLinkedList list = new DoublyLinkedList();
        list.addToFront(jane);
        list.addToFront(john);
        list.addToFront(mary);

        System.out.println(list.getSize());
        list.printList();

        list.addToEnd(mike);
        list.printList();
        System.out.println(list.getSize());

        list.removeFromFront();
        list.printList();
        System.out.println(list.getSize());

        list.removeFromEnd();
        list.printList();
        System.out.println(list.getSize());



    }
}
