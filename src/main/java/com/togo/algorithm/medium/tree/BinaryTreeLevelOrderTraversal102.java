package com.togo.algorithm.medium.tree;

import com.togo.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * <p>
 * Class : com.togo.algorithm.medium.tree.BinaryTreeLevelOrderTraversal102
 * <p>
 * Descdription:给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * 
 * 例如: 给定二叉树: [3,9,20,null,null,15,7],
 * 
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * 
 * 返回其层次遍历结果：
 * 
 * [ [3], [9,20], [15,7] ]
 *
 * 
 * 
 * @author taiyn
 * @version 1.0.0
 *          <p>
 *          --------------------------------------------------------------<br>
 *          修改履历：<br>
 *          <li>2019年3月25日，taiyn，创建文件；<br>
 *          --------------------------------------------------------------<br>
 *          </p>
 */
public class BinaryTreeLevelOrderTraversal102 {

	/**
	 * 
	 * <p>
	 * Method ：levelOrder
	 * <p>
	 * Description :先序遍历，将遍历结果记录在二维数组中，注意在每层第一次插入的时候需要扩容
	 *
	 * @param root
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年3月25日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> listDouble = new ArrayList<>();
		levelOrder(root, 0, listDouble);

		return listDouble;
	}

	private void levelOrder(TreeNode root, int level, List<List<Integer>> listDouble) {

		if (root == null)
			return;
		if (listDouble.size() == level) { // 该层第一次插值，需要扩容

			List<Integer> list = new ArrayList<>();
			list.add(root.val);
			listDouble.add(list);
		} else {
			listDouble.get(level).add(root.val);
		}

		levelOrder(root.left, level + 1, listDouble);
		levelOrder(root.right, level + 1, listDouble);
	}
}
