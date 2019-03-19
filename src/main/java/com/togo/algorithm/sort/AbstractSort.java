package com.togo.algorithm.sort;

public abstract class AbstractSort {

	protected abstract void sort(int[] nums);

	protected String getName() {

		return "default";
	}

	public void sortAndPrintInfo(int[] nums) {

		System.out.println("******************************");
		System.out.println("排序算法  :" + getName());
		long start = System.currentTimeMillis();
		sort(nums);
		long end = System.currentTimeMillis();
		System.out.println();
		long r = end - start;
		System.out.println("排序花费时间   " + r + " ms");
	}

	public void sortAndPrintInfoWithArray(int[] nums) {

		sortAndPrintInfo(nums);
		System.out.println("排序后结果");
		for (int i : nums)
			System.out.print(i + "  ");
	}

	public void sortAndPrint(int[] nums) {

		if (nums.length > 10)
			sortAndPrintInfo(nums);
		else
			sortAndPrintInfoWithArray(nums);
	}
}
