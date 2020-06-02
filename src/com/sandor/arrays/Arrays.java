package com.sandor.arrays;

public class Arrays {
    public static void arrayMain() {
        int[] array = new int[10];

        // write to the array
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        //read values
        for (int value : array) {
            System.out.println(value);
        }
    }
}
