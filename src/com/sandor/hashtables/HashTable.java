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
}
