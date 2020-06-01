package com.sandor.search;

public class LinearSearch {
    public static void main(String[] args) {
        int[] intArray = new int[] {54,46,83,66,95,92,43};


    }

    public static int search(int[] input, int value) {
        for(int i = 0; i< input.length; i++) {
            if(input[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
