package com.sandor.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] intArray = new int[]{-22, -15, 1, 7, 20, 35, 55};

        System.out.println(iterativeBinarySearch(intArray, -15));
        System.out.println(iterativeBinarySearch(intArray, 35));
        System.out.println(iterativeBinarySearch(intArray, 88888));

    }

    public static int iterativeBinarySearch(int[] input, int value) {
        int start = 0;
        int end = input.length;

        while (start < end) {
            int midpoint = (start + end) / 2;
            if (value == input[midpoint]) {
                return midpoint;
            } else if (value > input[midpoint]) {
                start = midpoint + 1;
            } else {
                end = midpoint;
            }
        }
        return -1;
    }

    public static int recursiveBinarySearch(int[] input, int value) {
        return recursiveBinarySearch(input, 0, input.length, value);
    }

    public static int recursiveBinarySearch(int[] input, int start, int end, int value) {
        if (start >= end) {
            return -1;
        }
        int midpoint = (start + end) / 2;

        if (input[midpoint] == value) {
            return midpoint;
        } else if (value > input[midpoint]) {
            return recursiveBinarySearch(input, midpoint + 1, end, value);
        } else {
            return recursiveBinarySearch(input, start, midpoint, value);
        }
    }
}
