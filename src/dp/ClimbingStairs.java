package dp;

/**
 * https://leetcode.cn/problems/climbing-stairs/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(3));

    }

    public int climbStairs(int n) {
        int[] dp = new int[n];
        if (n >= 1) {
            dp[0] = 1;
        }
        if (n >= 2) {
            dp[1] = 2;
        }
        for (int i = 3; i <= n; i++) {
            dp[i - 1] = dp[i - 2] + dp[i - 3];
        }
        return dp[n - 1];
    }

}
