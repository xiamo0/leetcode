package dp;

/**
 * https://leetcode.cn/problems/maximum-subarray/description/?envType=problem-list-v2&envId=dynamic-programming
 */

public class MaximumSubarray {

    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maximumSubarray.maxSubArray(nums));

    }

    public int maxSubArray(int[] nums) {

        //前1个元素的最大连续子数组 的和 为 dp[0]=nums[0]
        //前2个元素的最大连续子数组 的和 为 dp[1]=max(dp[0],前两个元素的和，第二个元素)
        //前3个元素的最大连续子数组 的和 为 dp[2]=max(dp[1],dp[1]+第三个元素，第3个元素)
        //前4个元素的最大连续子数组 的和 为 dp[3]=max(dp[2],dp[2]+第4个元素，第4个元素)
        //前5个元素的最大连续子数组 的和 为 dp[4]=max(dp[2],dp[2]+第3个元素+第4个元素，第3个元素+第4个元素,第4个元素)
        return 0;
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
