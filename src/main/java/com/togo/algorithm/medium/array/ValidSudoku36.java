package com.togo.algorithm.medium.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author AI
 * @desc 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 
 *       数字 1-9 在每一行只能出现一次。 数字 1-9 在每一列只能出现一次。 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 * 
 * @date 2019年4月29日
 *
 */
public class ValidSudoku36 {

	/**
	 * 
	 * @author AI
	 * @desc 思路就是记录三个条件下出现的次数；看了网上的评论，记录用数组就行，我这里用了map，多余
	 * 
	 * @param board
	 * @return
	 *
	 * @date 2019年4月29日
	 */
	public boolean isValidSudoku(char[][] board) {

		// 列、行、九宫格
		Map<String, Integer> col = new HashMap<>();
		Map<String, Integer> row = new HashMap<>();
		Map<String, Integer> nine = new HashMap<>();

		for (int i = 0; i < board.length; i++) {

			for (int j = 0; j < board[i].length; j++) {

				if (board[i][j] != '.') {
					// 设置三个map的key值
					String colK = i + "" + board[i][j];
					String rowK = "" + j + board[i][j];
					String nineK = i / 3 + "" + j / 3 + board[i][j];

					// 有值就报错
					if (col.get(colK) != null || row.get(rowK) != null || nine.get(nineK) != null)
						return false;

					// 没值就插值
					col.put(colK, 1);
					row.put(rowK, 1);
					nine.put(nineK, 1);
				}
			}
		}

		return true;
	}
}
