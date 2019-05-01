package com.togo.algorithm.easy.array;

/**
 * 
 * @author AI
 * @desc 给定一个 n × n 的二维矩阵表示一个图像。
 * 
 *       将图像顺时针旋转 90 度。
 * 
 *       说明：
 * 
 *       你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * 
 *       示例 1:
 * 
 *       给定 matrix = [ [1,2,3], [4,5,6], [7,8,9] ],
 * 
 *       原地旋转输入矩阵，使其变为: [ [7,4,1], [8,5,2], [9,6,3] ]
 * 
 *       示例 2:
 * 
 *       给定 matrix = [ [ 5, 1, 9,11], [ 2, 4, 8,10], [13, 3, 6, 7],
 *       [15,14,12,16] ],
 * 
 *       原地旋转输入矩阵，使其变为: [ [15,13, 2, 5], [14, 3, 4, 1], [12, 6, 8, 9], [16,
 *       7,10,11] ]
 *
 * 
 * 
 * @date 2019年5月1日
 *
 */
public class RotateImage48 {

	/**
	 * 
	 * @author AI
	 * @desc 先按照对角线翻转，然后按照行中线翻转
	 * 
	 * @param matrix
	 *
	 * @date 2019年5月1日
	 */
	public void rotate(int[][] matrix) {

		int n = matrix[0].length;
		for (int i = 0; i < n - 1; ++i) {
			for (int j = 0; j < n - i; ++j) {
				swap(matrix, i, j, n - 1 - j, n - 1 - i);
			}
		}
		for (int i = 0; i < n / 2; ++i) {
			for (int j = 0; j < n; ++j) {
				swap(matrix, i, j, n - 1 - i, j);
			}
		}

	}

	private void swap(int[][] matrix, int r1, int c1, int r2, int c2) {

		int tmp = matrix[r1][c1];
		matrix[r1][c1] = matrix[r2][c2];
		matrix[r2][c2] = tmp;
	}
}
