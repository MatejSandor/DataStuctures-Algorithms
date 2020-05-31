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
        if(hashtable[hashedKey] != null) {
            System.out.println("Sorry, the position is already occupied. :(");
        } else {
            hashtable[hashedKey] = employee;
        }
    }
}
