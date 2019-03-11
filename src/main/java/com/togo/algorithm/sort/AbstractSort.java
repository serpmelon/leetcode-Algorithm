package com.togo.algorithm.sort;

public abstract class AbstractSort {

	protected abstract void sort(int[] nums);

	public void sortAndPrintArray(int[] nums) {

		long start = System.currentTimeMillis();
		sort(nums);
		long end = System.currentTimeMillis();
		
		for (int i : nums) {

			System.out.print(i + "  ");
		}
		System.out.println();
		System.out.println("******************************");

	}
	
	public void sortTime(int[] nums) {
		
		long start = System.currentTimeMillis();
		sort(nums);
		long end = System.currentTimeMillis();
		long r = end - start;
		System.out.println("time " + r);
	}
}
