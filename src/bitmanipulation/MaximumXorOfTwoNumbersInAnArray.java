package bitmanipulation;

import java.util.Arrays;

/*
https://leetcode.cn/problems/maximum-xor-of-two-numbers-in-an-array/description/?envType=problem-list-v2&envId=bit-manipulation
数组中两个数的最大异或值

给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。



示例 1：

输入：nums = [3,10,5,25,2,8]
输出：28
解释：最大运算结果是 5 XOR 25 = 28.
示例 2：

输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
输出：127


提示：

1 <= nums.length <= 2 * 105
0 <= nums[i] <= 231 - 1

 */
public class MaximumXorOfTwoNumbersInAnArray {

    public static void main(String[] args) {
        System.out.println(5 ^ 25);
        int[] nums = {14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70};
        new MaximumXorOfTwoNumbersInAnArray().findMaximumXOR(nums);

        System.out.println(Integer.toBinaryString(66));
        System.out.println(Integer.toBinaryString(77));
        System.out.println(Integer.toBinaryString(91));
    }
//    1000010
//    1001101
//    1001111

//    1001101
//    1011011
//    1010110

    public int findMaximumXOR(int[] nums) {

        //3     11
        //10  1010
        //5    101
        //2     10
        //8   1000
        //25 11001
        //x  10


        int maxResult = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int i1 = i; i1 < nums.length; i1++) {
                int num1 = nums[i1];

                int temp = num ^ num1;
                maxResult = Math.max(temp, maxResult);
            }
        }
        return maxResult;
    }
}
