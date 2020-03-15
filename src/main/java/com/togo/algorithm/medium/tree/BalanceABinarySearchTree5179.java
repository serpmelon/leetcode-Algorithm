package com.togo.algorithm.medium.tree;

import com.togo.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author taiyn
 * @Description 给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。
 * <p>
 * 如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。
 * <p>
 * 如果有多种构造方法，请你返回任意一种。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balance-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 7:45 下午 2020/3/15
 **/
public class BalanceABinarySearchTree5179 {

    private List<Integer> list = new ArrayList<>();

    /**
     * @Author taiyn
     * @Description 二叉搜索树, 左边 < 中间 < 右边; 中序遍历构造列表, 然后以中点为根构造平衡树
     *
     * @Date 8:10 下午 2020/3/15
     * @Param [root]
     * @return com.togo.algorithm.common.TreeNode
     **/
    public TreeNode balanceBST(TreeNode root) {

        buildListFromTree(root);
        return buildBalance(0, list.size() - 1);
    }

    /**
     * @Author taiyn
     * @Description 中序遍历
     *
     * @Date 8:12 下午 2020/3/15
     * @Param [root]
     * @return void
     **/
    private void buildListFromTree(TreeNode root) {

        if(root == null)
            return;
        buildListFromTree(root.left);
        list.add(root.val);
        buildListFromTree(root.right);

    }

    /**
     * @Author taiyn
     * @Description 根据一个有序列表构建一个二叉平衡搜索树
     *
     * @Date 8:20 下午 2020/3/15
     * @Param [left, right]
     * @return com.togo.algorithm.common.TreeNode
     **/
    private TreeNode buildBalance(int left, int right) {

        if(left > right)
            return null;
        int mid = (right + left) / 2;

        TreeNode node = new TreeNode(list.get(mid));
        node.left = buildBalance(left, mid - 1);
        node.right = buildBalance(mid + 1, right);

        return node;
    }
}
