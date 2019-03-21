package com.togo.algorithm.medium.array;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.medium.ContainerWithMostWater
 * <p>
 * Descdription:给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i
 * 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 也就是说，题目提供了一个非负数组a[]，我们用这个数组在坐标上画直线，其中每条直线的坐标为(i, 0) (i,
 * a[i])，i为数字在数组中的索引，画完之后，我们可以看到是一堆垂直于x轴的直线，我们以其中两条线和X轴作为三个边，表示一个水桶，任意组合求其中容纳水最多的组合，即求面积最大的
 *
 * @author taiyn
 * @version 1.0.0
 *          <p>
 *          --------------------------------------------------------------<br>
 *          修改履历：<br>
 *          <li>2019年2月18日，taiyn，创建文件；<br>
 *          --------------------------------------------------------------<br>
 *          </p>
 */
public class ContainerWithMostWater11 {

	/**
	 * 
	 * <p>
	 * Method ：maxArea0
	 * <p>
	 * Description :暴力破解，两层循环，找到所有的组合，拿出其中最大的。O(n^2)
	 *
	 * @param height
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年2月18日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	public int maxArea0(int[] height) {
		int maxarea = 0;
		for (int i = 0; i < height.length; i++)
			for (int j = i + 1; j < height.length; j++)
				maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
		return maxarea;
	}

	/**
	 * 
	 * <p>
	 * Method ：maxArea1
	 * <p>
	 * Description
	 * :双指针法，从两边开始寻找，每次向可能比这次更大的方向移动，即每次移动长（x轴）肯定是缩小了，高肯定要向高的移动，所以两个边只有矮的那边继续移动才有可能获取到更大的面积
	 *
	 * @param height
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年2月18日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	public int maxArea1(int[] height) {
		int maxarea = 0, l = 0, r = height.length - 1;
		while (l < r) {
			maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
			if (height[l] < height[r])
				l++; // 右面高，左面移动
			else
				r--;
		}
		return maxarea;
	}
}
