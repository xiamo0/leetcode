import java.util.Arrays;

/**
 * https://leetcode.cn/problems/target-sum/description/?envType=problem-list-v2&envId=2cktkvj
 */
public class TargetSum_494 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3; // 你可以更改这个值来测试不同的 n
        findTargetSumWays(nums, target);

    }

    public static int findTargetSumWays(int[] nums, int target) {

        if (Arrays.stream(nums).sum()<target){
            return 0;
        }
        int column = nums.length;
        int row = (int) Math.pow(2, column);
        //int[][] operators = new int[row][column];
        int count = 0;
        for (int i = 0; i < row; i++) {
            int cur = i;
            int sum = 0;
            for (int j = column - 1; j >= 0; j--) {
                int temp = cur % 2;
                cur = cur / 2;
                //operators[i][j] = temp;
                if (temp == 1) {
                    sum = sum + nums[j];
                } else {
                    sum = sum - nums[j];
                }
            }
            if (sum == target) {
//                System.out.println(i);
                count++;
            }
        }

        return count;

    }

}

