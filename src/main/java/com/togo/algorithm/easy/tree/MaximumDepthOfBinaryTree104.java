package com.togo.algorithm.easy.tree;

import com.togo.algorithm.common.TreeNode;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.easy.tree.MaximumDepthOfBinaryTree104
 * <p>
 * Descdription:给定一个二叉树，找出其最大深度。
 * 
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例： 给定二叉树 [3,9,20,null,null,15,7]，
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 * 
 * 
 * 返回它的最大深度 3 。
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
public class MaximumDepthOfBinaryTree104 {

	/**
	 * 
	 * <p>Method ：maxDepth
	 * <p>Description : 分别算出左子树和右子树的最深值，取最大值 + 1即为该树的最大深度
	 *
	 * @param root
	 * @return 
	 * @author  taiyn
	 *<p>
	 *--------------------------------------------------------------<br>
	 * 修改履历：<br>
	 *        <li> 2019年3月25日，taiyn，创建方法；<br>
	 *--------------------------------------------------------------<br>
	 *</p>
	 */
	public int maxDepth(TreeNode root) {

		if (root == null)
			return 0;

		int left = maxDepth(root.left);
		int right = maxDepth(root.right);

		return Math.max(left, right) + 1;
	}
}
