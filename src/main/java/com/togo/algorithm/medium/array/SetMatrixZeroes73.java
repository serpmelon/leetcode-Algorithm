package com.togo.algorithm.medium.array;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.medium.array.SetMatrixZeroes73
 * <p>
 * Descdription: 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * 
 * 示例 1:
 * 
 * 输入: [ [1,1,1], [1,0,1], [1,1,1] ] 输出: [ [1,0,1], [0,0,0], [1,0,1] ]
 * 
 * 示例 2:
 * 
 * 输入: [ [0,1,2,0], [3,4,5,2], [1,3,1,5] ] 输出: [ [0,0,0,0], [0,4,5,0], [0,3,1,0]
 * ]
 *
 * @author taiyn
 * @version 1.0.0
 *          <p>
 *          --------------------------------------------------------------<br>
 *          修改履历：<br>
 *          <li>2019年4月22日，taiyn，创建文件；<br>
 *          --------------------------------------------------------------<br>
 *          </p>
 */
public class SetMatrixZeroes73 {

	/**
	 * 
	 * <p>
	 * Method ：setZeroes
	 * <p>
	 * Description :思路大概是这样，找到第一个出现零的地方，使用这个零所在行和列记录其他出现的零。然后遍历设置零。
	 *
	 * @param matrix
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年4月22日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	public void setZeroes(int[][] matrix) {

		// c是行，r是列，这里我把一维数组称为列，二维数组称为行
		int c = -1;
		int r = -1;

		// 遍历二维数组
		for (int ir = 0; ir < matrix.length; ir++) {

			for (int ic = 0; ic < matrix[ir].length; ic++) {

				// 找到零
				if (matrix[ir][ic] == 0) {
					// 如果是第一个零，则设置坐标
					if (c < 0 || r < 0) {
						c = ic;
						r = ir;
					}
					// 后面的零的坐标映射到第一个零的行和列上
					matrix[ir][c] = 0;
					matrix[r][ic] = 0;
				}
			}
		}

		// 如果没有领则直接返回
		if (c < 0 || r < 0)
			return;

		// 遍历列，找到标记行上有零的列
		for (int i = 0; i < matrix.length; i++) {

			if (matrix[i][c] == 0) {

				// 将有标记的这列值都设置为零
				for (int j = 0; j < matrix[i].length; j++) {

					// 用来标记的列不参与设置
					if (i != r)
						matrix[i][j] = 0;
					else
						break;
				}
			}
		}

		// 同理，遍历行
		for (int i = 0; i < matrix[r].length; i++) {

			if (matrix[r][i] == 0) {

				for (int j = 0; j < matrix.length; j++) {
					if (i != c)
						matrix[j][i] = 0;
					else
						break;
				}
			}
		}

		// 行列遍历完后对标记行列遍历设置零
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][c] = 0;
		}

		for (int i = 0; i < matrix[r].length; i++) {
			matrix[r][i] = 0;
		}
	}
}
