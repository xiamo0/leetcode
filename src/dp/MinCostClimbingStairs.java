package dp;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/min-cost-climbing-stairs/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] cost = {
                10, 15, 20
        };
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int[] dp = new int[length + 1];
        // 坐标为 n 楼顶就是 n+1

        for (int i = 2; i < dp.length; i++) {
            if (i <= 1) {
                dp[i] = 0;
            }
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[length];

    }

}
