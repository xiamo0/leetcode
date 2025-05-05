package dp;

import java.util.*;

/**
 * https://leetcode.cn/problems/number-of-longest-increasing-subsequence/?envType=problem-list-v2&envId=dynamic-programming
 */
public class NumberOfLongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        System.out.println(new NumberOfLongestIncreasingSubsequence().findNumberOfLIS(nums));
    }

    public int findNumberOfLIS(int[] nums) {

        int length = nums.length;
        //以 nums[i] 结尾的最长递增子序列的长度。
        int[] lengths = new int[length];
        //以 nums[i] 结尾的、长度为 lengths[i] 的子序列个数。
        int[] counts = new int[length];
        Arrays.fill(lengths, 1);
        Arrays.fill(counts, 1);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (lengths[j] + 1 > lengths[i]) {
                        lengths[i] = lengths[j] + 1;
                        counts[i] = counts[j];
                        continue;
                    }
                    if (lengths[j] + 1 == lengths[i]) {
                        counts[i] += counts[j];
                    }
                }
            }
        }
        int max = Arrays.stream(lengths).max().orElse(-1);
        int totalCount = 0;
        for (int i = 0; i < lengths.length; i++) {
            if (lengths[i] == max) {
                totalCount += counts[i];
            }
        }
        return totalCount;

    }
}