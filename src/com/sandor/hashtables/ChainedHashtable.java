package com.sandor.hashtables;

import com.sandor.Employee;

import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHashtable {
    private LinkedList<StoredData>[] hashtable;

    public ChainedHashtable() {
        hashtable = new LinkedList[10];
        for (int i = 0; i < hashtable.length; i++) {
            hashtable[i] = new LinkedList<StoredData>();
        }
    }

    private int hashKey(String key) {
        return Math.abs(key.hashCode() % hashtable.length);
    }

    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);
        hashtable[hashedKey].add(new StoredData(key,employee));
    }

    public Employee get(String key) {
        int hashedKey = hashKey(key);
        ListIterator<StoredData> iterator = hashtable[hashedKey].listIterator();
        StoredData employee = null;
        while (iterator.hasNext()) {
            employee = iterator.next();
            if(employee.key.equals(key)) {
                return employee.employee;
            }
        }

        return null;
    }

    public Employee remove(String key) {
        int hashedKey = hashKey(key);
        ListIterator<StoredData> iterator = hashtable[hashedKey].listIterator();
        StoredData employee = null;
        int index = -1;

        while (iterator.hasNext()) {
            employee = iterator.next();
            index++;
            if(employee.key.equals(key)) {
                break;
            }
        }

        if (employee == null || !employee.key.equals(key)) {
            return null;
        } else {
            hashtable[hashedKey].remove(index);
            return employee.employee;
        }
    }

    public void printHashtable() {
        for(int i=0; i<hashtable.length; i++) {
            if(hashtable[i].isEmpty()) {
                System.out.println("Position" + i + ": empty");
            } else {
                System.out.println("Position" + i + ": empty");
                ListIterator<StoredData> iterator = hashtable[i].listIterator();
                while (iterator.hasNext()) {
                    System.out.print(iterator.next().employee);
                    System.out.print(" -> ");
                }
                System.out.println("null");
            }
        }
    }
}
