package dp;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/jump-game-ii/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class JumpGameii {

    public static void main(String[] args) {
        JumpGameii jumpGameii = new JumpGameii();
        int[] nums = {2, 0, 2, 0, 1};
        System.out.println(jumpGameii.jump(nums));

    }

    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    dp[i] = Math.min(dp[i], (dp[j] + 1));
                }
            }
        }

        return dp[nums.length - 1];
    }

}
//1.	判断是否适用 DP（最优子结构+重叠子问题）
//        2.	定义状态 dp[i]
//
//        3.	写出状态转移方程
//4.	初始化
//5.	确定遍历顺序
//6.	处理边界情况
//7.	优化（空间压缩、二分、矩阵快速幂）