package com.togo.algorithm.easy.tree;


import com.togo.algorithm.common.TreeNode;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.easy.tree.ConvertSortedArrayToBinarySearchTree108
 * <p>
 * Descdription: 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 
 * 示例:
 * 
 * 给定有序数组: [-10,-3,0,5,9],
 * 
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * 
 *      0
 *     / \
 *   -3   9
 *   /   /
 * -10  5
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
public class ConvertSortedArrayToBinarySearchTree108 {

	/**
	 * 
	 * <p>
	 * Method ：sortedArrayToBST
	 * <p>
	 * Description :二叉树中序遍历的逆过程，数组的中间值即为根，根两侧即为左右子树，继续二分递归
	 *
	 * @param nums
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年3月25日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	public TreeNode sortedArrayToBST(int[] nums) {

		if (nums == null || nums.length == 0)
			return null;
		return getTree(nums, 0, nums.length - 1);
	}

	private TreeNode getTree(int[] nums, int left, int right) {

		if (left > right)
			return null;
		// 取中间值
		int mid = (left + right) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = getTree(nums, left, mid - 1);
		root.right = getTree(nums, mid + 1, right);

		return root;
	}
}
