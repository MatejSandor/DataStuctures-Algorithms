package com.sandor.sorts;

public class MergeSort {
    public static void main(String[] args) {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        for(int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i]);
            if(i != intArray.length - 1) {
                System.out.print(", ");
            }
        }
    }

    public static void mergeSort(int[] input, int start, int end) {
        if(end - start < 2) { return; }

        int mid = (start + end) / 2;

        mergeSort(input,start,mid);
        mergeSort(input, mid, start);
        merge(input,start,mid,end);

    }

    public static void merge(int[] input, int start, int mid, int end) {

    }
}
