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
        if (occupied(hashedKey)) {
            int stopIndex = hashedKey;
            if (hashedKey == hashtable.length - 1) {
                hashedKey = 0;
            } else {
                hashedKey++;
            }

            while (occupied(hashedKey) && hashedKey != stopIndex) {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        if (occupied(hashedKey)) {
            System.out.println("Sorry, the position is already occupied. :(");
        } else {
            hashtable[hashedKey] = new StoredData(key, employee);
        }
    }

    public Employee get(String key) {
        int hashedKey = hashKey(key);
        if (hashedKey == -1) {
            return null;
        }
        return hashtable[hashedKey].employee;
    }

    public Employee remove(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }

        Employee employee = hashtable[hashedKey].employee;
        hashtable[hashedKey] = null;

        StoredData[] oldHashtable = hashtable;

        hashtable = new StoredData[oldHashtable.length];
        for (int i = 0; i < oldHashtable.length; i++) {
            if (oldHashtable[i] != null) {
                put(oldHashtable[i].key, oldHashtable[i].employee);
            }
        }


        return employee;
    }

    private int findKey(String key) {
        int hashedKey = hashKey(key);
        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        }

        int stopIndex = hashedKey;
        if (hashedKey == hashtable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }

        while (hashedKey != stopIndex
                && hashtable[hashedKey] != null
                && !hashtable[hashedKey].key.equals(key)) {
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        if (hashtable[hashedKey] != null
                && !hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        } else {
            return -1;
        }

    }

    public void printHashtable() {
        for (int i = 0; i < hashtable.length; i++) {
            if (hashtable[i] == null) {
                System.out.println("empty");
            } else {
                System.out.println(hashtable[i].employee);
            }
        }
    }

    private boolean occupied(int index) {
        return hashtable[index] != null;
    }
}
