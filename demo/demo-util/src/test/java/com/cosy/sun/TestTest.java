package com.cosy.sun;

import com.cosy.sun.algorithm.*;
import org.junit.Test;

import java.util.Arrays;

public class TestTest {

	private static int[] arr = {6, 5, 10, 15, 12, 50, 4, 2, 7, 23, 22, 14, 16, 19, 20, 8};
	private static int[] arrT = {4, 1, 10, 2};
	private static double[] arrDouble = {0.2, 0.4, 0.35, 0.33, 0.9, 0.75};

	@Test
	public void bucketSort() {
		BucketSort.bucketSort(arrDouble);
		System.out.println("succ" + Arrays.toString(arrDouble));
	}

	@Test
	public void insertionSort() {
		int[] sort = InertionSort.sort(arr);
		System.out.println(Arrays.toString(sort));

	}

	@Test
	public void mergeSort() {
		MergeSort.splitArray(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	@Test
	public void quickSort() {
		QuickSort.quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	@Test
	public void maxHeapify() {
		HeapSort.maxHeapifyInit(arrT, 0);
		System.out.println(Arrays.toString(arrT));
	}

	@Test
	public void buildMaxHeap() {
		HeapSort.buildMaxHeapInit(arr);
		System.out.println(Arrays.toString(arr));
	}

	@Test
	public void heapSort() {
		HeapSort.heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	@Test
	public void countSort() {
		int[] res = CountingSort.countSort(arr);
		System.out.println(Arrays.toString(res));
	}


}
