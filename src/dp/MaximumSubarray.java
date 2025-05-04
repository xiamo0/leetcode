package dp;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/maximum-subarray/description/?envType=problem-list-v2&envId=dynamic-programming
 */

public class MaximumSubarray {

    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maximumSubarray.maxSubArray(nums));

    }

    static int calcPreMax(int[] nums, int begin, int end) {
        int sum = 0;
        for (int i = begin + 1; i <= end; i++) {
            sum += nums[i];
        }
        return sum;

    }

    public int maxSubArray(int[] nums) {
//        curSum 表示以当前位置结尾的最大子数组和。
//        maxSum 表示到当前为止的最大子数组和。
        int curSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curSum = Math.max(nums[i], curSum + nums[i]);
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }

    public int maxSubArray1(int[] nums) {
        int length = nums.length;
        int[][] dp = new int[length][length];
        int max = nums[0];
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                int num = nums[j];
                if (j == i) {
                    dp[i][j] = num;
                } else {
                    int pre = dp[i][j - 1];
                    dp[i][j] = pre + num;
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}
