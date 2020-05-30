package com.sandor.sorts;

public class RadixSort {
    public static void main(String[] args) {
        int[] intArray = {4725,4586,1330,8792,1594,5796};

        radixSort(intArray,10,4);

        for(int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i]);
            if(i != intArray.length - 1) {
                System.out.print(", ");
            }
        }
    }

    public static void radixSort(int[] input, int radix, int width) {
        for(int i = 0; i < width; i++) {
            singleRadixSort(input,i,radix);
        }
    }

    public static void singleRadixSort(int[] input, int position, int radix) {

        int numItems = input.length;
        int[] countArray = new int[radix];

        for(int value : input) {
            countArray[getDigit(position,value,radix)]++;
        }

        for(int j = 1; j<radix; j++) {
            countArray[j] += countArray[j-1];
        }

        int[] temp = new int[radix];
        for(int tempIndex = numItems-1; tempIndex>=0; tempIndex--) {
            temp[--countArray[getDigit(position,input[tempIndex],radix)]] = input[tempIndex];
        }

        if (numItems >= 0) System.arraycopy(temp, 0, input, 0, numItems);

    }

    public static int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(radix, position) % radix;
    }
}
