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
        int[] maxValue = new int[length];
        int[] minValue = new int[length];
        maxValue[0] = nums[0];
        minValue[0] = nums[0];
        int result = maxValue[0];
        for (int i = 1; i < length; i++) {
            int curValue = nums[i];
            maxValue[i] = Math.max(curValue, Math.max(curValue * maxValue[i - 1], curValue * minValue[i - 1]));
            minValue[i] = Math.min(curValue, Math.min(curValue * maxValue[i - 1], curValue * minValue[i - 1]));
            result = Math.max(result, maxValue[i]);
        }
        return result;
    }

    public int maxProduct1(int[] nums) {
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
