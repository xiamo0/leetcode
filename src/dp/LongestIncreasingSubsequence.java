package dp;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/longest-increasing-subsequence/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        LongestIncreasingSubsequence subsequence = new LongestIncreasingSubsequence();
        int[] nums = {4, 10, 4, 3, 8, 9};
        System.out.println(subsequence.lengthOfLIS(nums));

    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
