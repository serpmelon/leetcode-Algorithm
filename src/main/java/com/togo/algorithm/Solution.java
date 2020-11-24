package com.togo.algorithm;

import com.togo.algorithm.common.TreeNode;

import java.util.*;

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
 * @date Created in 2019年07月07日 11:03
 * @since 1.0
 */
class Solution {
    private static List<Integer> list = new ArrayList<>();

    public static int numTriplets(int[] nums1, int[] nums2) {

        int count = 0;
        long e = (long) 1e9;

        for(int i = 0; i < nums1.length; i++) {

            for(int j = 0; j < nums2.length - 1; j++) {

                for(int k = j + 1; k < nums2.length; k++) {
                    if(((long)nums1[i] * (long)nums1[i]) % e == ((long) nums2[j] * (long)nums2[k])%e) {
                        count++;
                    }
                }
            }
        }

        for(int i = 0; i < nums2.length; i++) {

            for(int j = 0; j < nums1.length - 1; j++) {

                for(int k = j + 1; k < nums1.length; k++) {
                    if(((long)nums2[i] * (long)nums2[i])%e == ((long)nums1[j] * (long)nums1[k]) % e) {
                        count++;
                    }
                }
            }
        }
        // 3474496 4298441792
        return count;
    }

    public static boolean isSymmetric(TreeNode root) {

        if((root == null) || (root.left == null && root.right == null))
            return true;
        if(root.left == null || root.right == null)
            return false;

        return root.left.val == root.right.val && isSymmetric(root.left) && isSymmetric(root.right);
    }

    public static void main(String[] args) {

//3
//[[0,1],[1,2],[0,2]]
//[0.5,0.5,0.2]
//0
//2
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(3);

        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        b.left = e;
        b.left = f;
        System.out.println(isSymmetric(root));
//        char[] aa = "".toCharArray();
//
//        System.out.println(43024L * 99908L);
//        int[] a = {43024,99908};
//        int[] b = {1864};
//        System.out.println(numTriplets(a, b));;
    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {

        if(root == null) return new ArrayList<>();

        int i = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        while(queue.size() != 0) {
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int j = 0; j < size; j++) {
                if(i % 2 == 0) {
                    TreeNode node = queue.pollFirst();
                    tmp.add(node.val);
                    if(node.left != null) {
                        queue.addLast(node.left);
                    }
                    if(node.right != null) {
                        queue.addLast(node.right);
                    }
                }  else {
                    // 从队尾取
                    TreeNode node = queue.pollLast();
                    tmp.add(node.val);
                    if(node.left != null) {
                        queue.addFirst(node.left);
                    }
                    if(node.right != null) {
                        queue.addFirst(node.right);
                    }
                }
            }
            list.add(tmp);
            i++;
        }

        return list;
    }
}