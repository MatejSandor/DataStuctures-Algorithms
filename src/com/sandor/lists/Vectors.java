package com.sandor.lists;

import com.sandor.Employee;

import java.util.List;
import java.util.Vector;

public class Vectors {
    public static void vectorsMain() {

        List<Employee> employeeList = new Vector<>();
        employeeList.add(new Employee("Jane", "Jones", 123));
        employeeList.add(new Employee("John", "Doe", 4567));
        employeeList.add(new Employee("Mary", "Smith", 22));
        employeeList.add(new Employee("Mike", "Wilson", 3245));

    }
}
