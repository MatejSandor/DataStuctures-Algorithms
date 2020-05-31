package com.sandor.hashtables;

import com.sandor.Employee;

public class HashTable {
    Employee[] hashtable;

    public HashTable(int capacity) {
        hashtable = new Employee[capacity];
    }

    private int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);
        if(occupied(hashedKey)) {
            int stopIndex = hashedKey;
            if(hashedKey == hashtable.length - 1) {
                hashedKey = 0;
            } else {
                hashedKey++;
            }

            while (occupied(hashedKey) && hashedKey != stopIndex) {
                hashedKey = (hashedKey+1) % hashtable.length;
            }
        }

        if(occupied(hashedKey)) {
            System.out.println("Sorry, the position is already occupied. :(");
        } else {
            hashtable[hashedKey] = employee;
        }
    }

    public Employee get(String key) {
        int hashedKey = hashKey(key);
        return hashtable[hashedKey];
    }

    public void printHashtable() {
        for (Employee employee : hashtable) {
            System.out.println(employee);
        }
    }

    private boolean occupied(int index) {
        return hashtable[index] != null;
    }
}
