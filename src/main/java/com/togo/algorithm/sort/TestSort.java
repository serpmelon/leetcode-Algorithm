package com.togo.algorithm.sort;

import java.util.Random;

public class TestSort {

	private static Random random = new Random();

	public static void main(String[] args) {

		int n = 50;
		int[] a = createArray(n, 0, 100);

		AbstractSort sort = new BubbleSort();
		sort.sortAndPrint(a.clone());

		sort = new InsertionSort();
		sort.sortAndPrint(a.clone());

		sort = new SelectionSort();
		sort.sortAndPrint(a.clone());

		sort = new MergeSort();
		sort.sortAndPrint(a.clone());
		
		sort = new QuickSort();
		sort.sortAndPrint(a.clone());
	}

	public static int[] createArray(int n, int min, int max) {

		int[] a = new int[n];
		if (n <= 10)
			System.out.println("create array :");
		for (int i = 0; i < n; i++) {

			a[i] = random.nextInt(max - min) + min;
			if (n <= 10)
				System.out.print(a[i] + " ");
		}

		System.out.println();
		return a;
	}
}
