package com.cosy.sun.algorithm.sort;

public class SelectSort {
    public static int[] sort(int[] array) {
        for (int i = 0; i <array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            HeapSort.swap(array, i, minIndex);
        }
        return array;
    }

}
