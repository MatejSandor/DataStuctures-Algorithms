package com.sandor.sorts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public static void main(String[] args) {
        int[] intArray = new int[] {54,46,83,66,95,92,43};

        bucketSort(intArray);


        for(int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i]);
            if(i != intArray.length - 1) {
                System.out.print(", ");
            }
        }
    }

    public static void bucketSort(int[] input) {
        List<Integer>[] buckets = new List[10];

        for(int i = 0; i<buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i<input.length; i++) {
            buckets[hash(i)].add(input[i]);
        }

        for(List bucket: buckets) {
            Collections.sort(bucket);
        }

        int j = 0;
        for(int i = 0; i<buckets.length; i++) {
            for(int value: buckets[i]) {
                input[j++] = value;
            }
        }
    }

    public static int hash(int value) {
        return value / 10;
    }
}
