package com.togo.algorithm.medium.tree;

import com.togo.algorithm.common.TreeNode;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.medium.tree.ValidateBinarySearchTree98
 * <p>
 * Descdription:给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 
 * 假设一个二叉搜索树具有如下特征：
 * 
 * 节点的左子树只包含小于当前节点的数。 节点的右子树只包含大于当前节点的数。 所有左子树和右子树自身必须也是二叉搜索树。
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
public class ValidateBinarySearchTree98 {

	/**
	 * 中序遍历中最小值
	 */
	long i = Long.MIN_VALUE;

	/**
	 * 
	 * <p>
	 * Method ：isValidBST
	 * <p>
	 * Description :中序遍历，升序排列
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
	public boolean isValidBST(TreeNode root) {

		if (root == null)
			return true;

		if (isValidBST(root.left)) { // 先判断左子树

			if (i < root.val) { // 根节点一定大于左子树
				// 将根节点的值存下来，然后右子树必须大于这个根节点
				i = root.val;
				return isValidBST(root.right);
			}
		}

		return false;
	}
}
