package dp;

/**
 * https://leetcode.cn/problems/maximum-product-subarray/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class MaximumProductSubarray {
    public static void main(String[] args) {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        int[] nums = {2, 3, -2, 4};
        System.out.println(maximumProductSubarray.maxProduct(nums));

    }

    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[][] dp = new int[length][length];
        int max = nums[0];
        for (int i = 0; i < length; i++) {
            dp[i][i] = nums[i];
            if (max < nums[i]) {
                max = nums[i];
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int v = nums[j] * dp[i][j - 1];
                dp[i][j] = v;
                if (max < dp[i][j]) {
                    max = dp[i][j];
                }
            }
        }
        return max;
    }
}
