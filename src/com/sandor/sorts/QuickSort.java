package com.sandor.sorts;

public class QuickSort {
    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        quickSort(intArray,0,intArray.length);

        for(int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i]);
            if(i != intArray.length - 1) {
                System.out.print(", ");
            }
        }
    }

    public static void quickSort(int[] input, int start, int end) {
        if(end - start < 2) { return; }
        int pivotIndex = partition(input, start, end);
        quickSort(input,start,pivotIndex);
        quickSort(input, pivotIndex+1, end);
    }

    public static int partition(int[] input, int start, int end) {
        int pivot = input[start];
        int i = start;
        int j = end;

        while(i<j) {
            while(i<j && input[--j] >= pivot);
            if(i<j) {
                input[i] = input[j];
            }
            while(i<j && input[++i] <= pivot);
            if(i<j) {
                input[j] = input[i];
            }
        }
        pivot = input[j];
        System.out.println(pivot);
        return j;
    }
}
