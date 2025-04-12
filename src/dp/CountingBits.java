package dp;

/**
 * https://leetcode.cn/problems/counting-bits/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class CountingBits {
    public static void main(String[] args) {
        CountingBits countingBits = new CountingBits();
        System.out.println(countingBits.countBits(8));

    }

    public int[] countBits(int n) {
        //dp[i] i是奇数时，dp[i]=dp[i-1]+1;
        //dp[i] i是偶数时，dp[i]=dp[i/2];
        int[] dp = new int[n + 1];
        for (int i = 1; i < dp.length; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2];
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        return dp;
    }
}
