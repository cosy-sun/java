package com.cosy.sun.algorithm.sort;

import org.apache.commons.lang3.ArrayUtils;

public class SelectSort {
    public static int[] sort(int[] array) {
        for (int i = 0; i <array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            ArrayUtils.swap(array, i, minIndex);
        }
        return array;
    }

}
