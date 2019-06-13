package com.togo.algorithm.easy.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 *
 * 例如，给定一个 3叉树 :
 *
 * 返回其层序遍历:
 *
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
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
 * @date Created in 2019年06月13日 12:59
 * @since 1.0
 */
public class N_aryTreeLevelOrderTraversal429 {

    /**
     * <pre>
     * desc : 广度优先，遍历每个节点的所有子节点，并加入队列，循环从队列中获取节点重复上述步骤
     * @author : taiyn
     * date : 2019/6/13 13:03
     * @param root
     * @return java.util.List<java.util.List<java.lang.Integer>>
     * </pre>
     */
    public List<List<Integer>> dfsLevelOrder(Node root) {

        List<List<Integer>> doubleList = new ArrayList<>();

        if (root == null)
            return doubleList;

        // 将头节点放入队列
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);

        // 当队列中存在节点则循环
        while (queue.size() > 0) {

            // 层级数据
            List<Integer> tmpList = new ArrayList<>();
            // 当前队列数据
            List<Node> nodeList = createNodeList(queue);
            for (Node n : nodeList) {

                tmpList.add(n.val);
                // 将节点的所有子节点加入到队列中
                queue.addAll(n.children);
            }

            doubleList.add(tmpList);
        }

        return doubleList;
    }

    /**
     * <pre>
     * desc : 根据当前队列创建当前层级的数据
     * @author : taiyn
     * date : 2019/6/13 13:04
     * @param queue
     * @return java.util.List<com.togo.algorithm.easy.tree.N_aryTreeLevelOrderTraversal429.Node>
     * </pre>
     */
    private List<Node> createNodeList(LinkedList<Node> queue) {

        if (queue == null)
            return new ArrayList<>();

        List<Node> list = new ArrayList<>();
        while (queue.size() > 0) {

            list.add(queue.poll());
        }

        return list;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
