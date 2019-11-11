package com.togo.algorithm.medium.array;

/**
 * <p>给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。</p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author taiyn
 * @version 1.0
 * @date Created in 2019年11月11日 08:52
 * @since 1.0
 */
public class JumpGame55 {

    /**
     * <pre>
     * desc : 每次寻找当前结点能跳跃的最大距离，根据题目要求，不是说只到最远点，
     * 而是可以到达这中间的任意一点，所以再从这中间找最远的
     * @author : taiyn
     * date : 2019-11-11 08:56
     * @param : [nums]
     * @return boolean
     * </pre>
     */
    public boolean canJump(int[] nums) {

        // 当前可以跳跃最远的位置
        int max = 0;

        for (int i = 0; i < nums.length; i++) {

            if (i > max) // 最远距离小于当前位置，说明到达不到当前位置，也就不可能到达最后
                return false;
            // 每次取当前能到达的最远距离
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length) // 说明已经到达最后
                return true;
        }

        return true;
    }
}