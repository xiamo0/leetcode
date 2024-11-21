/**
 * https://leetcode.cn/problems/target-sum/description/?envType=problem-list-v2&envId=2cktkvj
 */
public class TargetSum_494 {
    public static void main(String[] args) {
        int[] nums={};
        int target = 10; // 你可以更改这个值来测试不同的 n
        System.out.println(": " + findTargetSumWays(nums,target));
    }
    public  static int findTargetSumWays(int[] nums, int target) {


        int count=0;
        int sum=0;
        for (int num : nums) {
            sum=sum+num;
        }
        int sumA = (sum + target) / 2;
        if (sum*2 !=(sum+target)){
            return 0;
        }
        //
        int[][] dp=new int[nums.length+1][target+1];
        dp[0][0]=1;
        for (int i = 1; i <dp.length ; i++) {
            for (int j = 0; j <=target ; j++) {

            }
        }


        return -1;

    }

}

