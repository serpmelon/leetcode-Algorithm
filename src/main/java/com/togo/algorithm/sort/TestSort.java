package com.togo.algorithm.sort;

import java.util.Random;

public class TestSort {

	private static Random random = new Random();

	public static void main(String[] args) {

		int n = 100000;
		int[] a = createArray(10, 0, 10);

		AbstractSort sort = new BubbleSort();
		// sort.sortAndPrintArray(a.clone());
		sort.sortTime(a.clone());

		sort = new InsertionSort();
		// sort.sortAndPrintArray(a.clone());
		sort.sortTime(a.clone());

		sort = new SelectionSort();
		sort.sortAndPrintArray(a.clone());
	}

	public static int[] createArray(int n, int min, int max) {

		int[] a = new int[n];

		System.out.println("create array :");
		for (int i = 0; i < n; i++) {

			a[i] = random.nextInt(max - min) + min;
			System.out.print(a[i] + "  ");
		}

		System.out.println();
		return a;
	}
}
