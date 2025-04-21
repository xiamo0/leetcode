package dp;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/min-cost-climbing-stairs/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] cost={
                10,15,20
        };
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(cost));
    }
    public int minCostClimbingStairs(int[] cost) {

        //当楼顶为i 时 的最低花费 dp[i]
        //dp[i] =min(dp[i-1],dp[i-2])
        int[]dp=new int[cost.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=cost[0];
        for (int i = 1; i <dp.length ; i++) {
            if (i==1){
                //0+2>1
                dp[i]=Math.min(dp[0],cost[i]);
            }
            if (i==2){
                dp[i]=

            }

        }

    }

}
