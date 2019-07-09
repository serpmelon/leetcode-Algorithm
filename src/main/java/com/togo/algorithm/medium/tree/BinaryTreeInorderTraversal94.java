package com.togo.algorithm.medium.tree;

import java.util.ArrayList;
import java.util.List;

import com.togo.algorithm.common.TreeNode;

/**
 * 
 * <p>
 * Class : com.togo.algorithm.medium.tree.BinaryTreeInorderTraversal94
 * <p>
 * Descdription:给定一个二叉树，返回它的中序 遍历。
 * 
 * 示例:
 * 
 * 输入: [1,null,2,3] 1 \ 2 / 3
 * 
 * 输出: [1,3,2]
 *
 * @author taiyn
 * @version 1.0.0
 *          <p>
 *          --------------------------------------------------------------<br>
 *          修改履历：<br>
 *          <li>2019年4月12日，taiyn，创建文件；<br>
 *          --------------------------------------------------------------<br>
 *          </p>
 */
public class BinaryTreeInorderTraversal94 {

	/**
	 * 
	 * <p>
	 * Method ：inorderTraversal
	 * <p>
	 * Description :中序遍历二叉树，中序指的就是根节点的顺序，左永远在右前面，然后前序就是 根 - 左 - 右，中序就是 左 - 根 - 右， 后续
	 * 左 - 右 - 根
	 *
	 * @param root
	 * @return
	 * @author taiyn
	 *         <p>
	 *         --------------------------------------------------------------<br>
	 *         修改履历：<br>
	 *         <li>2019年4月12日，taiyn，创建方法；<br>
	 *         --------------------------------------------------------------<br>
	 *         </p>
	 */
	public List<Integer> inorderTraversal(TreeNode root) {

		List<Integer> list = new ArrayList<>();

		if (root == null)
			return list;

		List<Integer> leftList = inorderTraversal(root.left);
		// 左子树不为空则添加到list
		if (leftList != null)
			list.addAll(leftList);
		// 然后添加根节点
		list.add(root.val);
		List<Integer> rightList = inorderTraversal(root.right);
		// 最后添加右子树
		if (rightList != null)
			list.addAll(rightList);

		return list;
	}
}
