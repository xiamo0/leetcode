import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/house-robber/description/?envType=problem-list-v2&envId=2cktkvj
 */
public class HouseRobber_198 {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2};
        System.out.println(rob(a));
    }

    public static int rob2(int[] nums) {
        return 0;
    }

    public static int rob(int[] nums) {

        int length = nums.length;

        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            int[] sum = new int[length];
            sum[0] = nums[0];
            sum[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < length; i++) {
                int sumI = nums[i] + sum[i - 2];
                sum[i] = Math.max(sumI, sum[i - 1]);
            }
            return sum[sum.length-1];
        }


    }

}
