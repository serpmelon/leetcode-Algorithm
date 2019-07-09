package com.togo.algorithm.medium.tree;

import com.togo.algorithm.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *
 * </p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author taiyn
 * @version 1.0
 * @date Created in 2019年07月09日 20:02
 * @since 1.0
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal105 {

    private Map<Integer, Integer> map = new HashMap<>();
    private int index = 0;

    /**
     * <pre>
     * desc : 前序遍历中的头节点肯定为整个树的根，在中序遍历中该节点的左右节点即为根节点的左右子树。前序遍历肯定会先将
     * 根节点的左子树遍历完。
     * @author : taiyn
     * date : 2019-07-09 20:04
     * @param [preorder, inorder]
     * @return com.togo.algorithm.common.TreeNode
     * </pre>
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (isEmpty(preorder) || isEmpty(inorder))
            return null;

        // 将中序遍历的数组记录在map中，方便获取某个节点的左右子树的范围
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);

        return build(0, inorder.length, preorder);
    }

    /**
     * <pre>
     * desc : 构造树
     * @author : taiyn
     * date : 2019-07-09 20:13
     * @param start 节点在中序中的开始位置, end 结束位置, preorder 前序
     * @return com.togo.algorithm.common.TreeNode
     * </pre>
     */
    private TreeNode build(int start, int end, int[] preorder) {

        if (start >= end)
            return null;

        // index指向当前树的根节点
        int val = preorder[index];
        // 前序遍历向后移动
        index++;
        // 找到根节点在中序中的位置
        int mid = map.get(val);
        TreeNode node = new TreeNode(val);
        node.left = build(start, mid, preorder);

        node.right = build(mid + 1, end, preorder);

        return node;
    }

    private boolean isEmpty(int[] intArray) {

        if (intArray == null || intArray.length == 0)
            return true;

        return false;
    }
}