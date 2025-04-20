package dp;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/perfect-squares/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class PerfectSquares {

    public static void main(String[] args) {
        PerfectSquares perfectSquares = new PerfectSquares();
        int n = 12;
        System.out.println(perfectSquares.numSquares(n));
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];

    }
}
