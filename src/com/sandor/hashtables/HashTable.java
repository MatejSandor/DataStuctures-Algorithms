package com.sandor.hashtables;

import com.sandor.Employee;

public class HashTable {
    StoredData[] hashtable;

    public HashTable(int capacity) {
        hashtable = new StoredData[capacity];
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
            hashtable[hashedKey] = new StoredData(key,employee);
        }
    }

    public Employee get(String key) {
        int hashedKey = hashKey(key);
        if(hashedKey == -1) {
            return null;
        }
        return hashtable[hashedKey].employee;
    }

    private int findKey(String key) {
        int hashedKey = hashKey(key);
        if(hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        }

        int stopIndex = hashedKey;
        if(hashedKey == hashtable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }

        while (hashedKey != stopIndex
                && hashtable[hashedKey] != null
                && !hashtable[hashedKey].key.equals(key)) {
            hashedKey = (hashedKey+1) % hashtable.length;
        }

        if(stopIndex == hashedKey) {
            return -1;
        } else {
            return hashedKey;
        }

    }

    public void printHashtable() {
        for (int i = 0; i<hashtable.length; i++) {
            System.out.println(hashtable[i]);
        }
    }

    private boolean occupied(int index) {
        return hashtable[index] != null;
    }
}
