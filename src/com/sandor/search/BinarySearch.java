package com.sandor.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] intArray = new int[] {-22,-15,1,7,20,35,55};

        System.out.println(iterativeBinarySearch(intArray,-15));
        System.out.println(iterativeBinarySearch(intArray,35));
        System.out.println(iterativeBinarySearch(intArray,88888));

    }

    public static int iterativeBinarySearch(int[] input, int value) {
       int start = 0;
       int end = input.length;

       while (start < end) {
           int midpoint = (start+end) / 2;
           if(value == input[midpoint]) {
               return midpoint;
           } else if (value > input[midpoint]) {
               start = midpoint+1;
           } else {
               end = midpoint;
           }
       }
       return -1;
    }
}
