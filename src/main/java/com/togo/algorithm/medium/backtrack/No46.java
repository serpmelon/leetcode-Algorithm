package com.togo.algorithm.medium.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author taiyn
 * @Description
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 *
 * @Date 上午8:32 2022/2/17
 **/
public class No46 {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;
    boolean[] check;
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>(0);
        this.nums = nums;
        this.check = new boolean[nums.length];
        List<Integer> track = new ArrayList<>();
        backtrack(track);
        return result;
    }

    /**
     * 回溯就是深度优先遍历dfs. 回溯指的是在搜索后把当前节点删除, 换另一种情况.
     * 先画决策树, 再想代码
     * @param track
     */
    private void backtrack(List<Integer> track){
        // 结束条件
        if(nums.length == track.size()) {
            result.add(new ArrayList<>(track));
        }
        // 循环
        for(int i = 0; i < nums.length; i++) {
            // 开始使用的是track.contains判断, 性能不好, 因为列表需要遍历判断每一个元素
            // 换成一个boolean数组, 性能提高很多, 从击败20%提升到80%.
            // 排除不合法元素
            if (check[i]) {
                continue;
            }
            // 做选择
            track.add(nums[i]);
            check[i] = true;
            // 进入下一层决策树
            backtrack(track);
            // 撤销选择
            track.remove(track.size() - 1);
            check[i] = false;
        }
    }

    public static void main(String[] args) {

        No46 no46 = new No46();
        int[] nums = new int[]{1,2,3};
        System.out.println(no46.permute(nums));
    }
}
