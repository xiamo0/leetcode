package dp;

/**
 * https://leetcode.cn/problems/partition-array-for-maximum-sum/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class PartitionArrayForMaximumSum {
    public static void main(String[] args) {
        int[] arr = {1, 15, 7, 9, 2, 5, 10};
        int k = 3;
        System.out.println(new PartitionArrayForMaximumSum().maxSumAfterPartitioning(arr, k));
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {

        //前 i 个数字的最大变换和
        int[] dp = new int[arr.length + 1];
        for (int i = 1; i < dp.length; i++) {
            int maxVal = 0;
            for (int j = 1; j <= k && j <= i; j++) {
                maxVal = Math.max(maxVal, arr[i - j]);
                dp[i] = Math.max(dp[i], dp[i - j] + maxVal * j);
            }
        }
        return dp[dp.length - 1];
    }
}
