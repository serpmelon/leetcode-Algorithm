package com.togo.algorithm.medium.tree;

import com.togo.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author taiyn
 * @version 1.0
 * @date Created in 2019年06月19日 08:50
 * @since 1.0
 */
public class BinaryTreeZigzagLevelOrderTraversal103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        if(root == null)
            return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        // 是否从左面开始遍历
        boolean left = true;

        while(queue.size() > 0){

            LinkedList<Integer> tmpLevel = new LinkedList<>();

            int currentSize = queue.size();
            for(int i = 0; i < currentSize; i++){

                TreeNode node = queue.poll();

                if(left)
                    tmpLevel.offer(node.val);
                else
                    tmpLevel.offerFirst(node.val);

                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }

            left = !left;
            result.add(tmpLevel);
        }

        return result;
    }
}