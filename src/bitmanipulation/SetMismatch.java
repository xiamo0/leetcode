package bitmanipulation;

import java.util.Arrays;

/*
https://leetcode.cn/problems/set-mismatch/description/?envType=problem-list-v2&envId=bit-manipulation


提示：

2 <= nums.length <= 104
1 <= nums[i] <= 104

 */
public class SetMismatch {

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 4, 6, 5};
        System.out.println(new SetMismatch().findErrorNums(nums));
    }

    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int chongfu = Integer.MAX_VALUE;
        int queshao = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (chongfu == nums[i]) {
                nums[i] = Integer.MIN_VALUE;
                break;
            } else {
                chongfu = nums[i];
            }
        }

        for (int i = 1; i <= nums.length; i++) {
            queshao = queshao ^ i;
            queshao = queshao ^ nums[i - 1];
        }
        int[] result = new int[2];
        result[0] = chongfu;
        result[1] = queshao;

//        a ^ a = 0（自己和自己异或为0）
//        a ^ 0 = a（任何数和0异或为自己）


        return result;

    }
}
