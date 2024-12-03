import java.util.Arrays;

/**
 * https://leetcode.cn/problems/partition-equal-subset-sum/?envType=problem-list-v2&envId=2cktkvj
 */
public class LetCode_416 {

    public static void main(String[] args) {
        int i = 1;
        System.out.println(3 & 1);
    }

    public boolean canPartition(int[] nums) {

        int sum = Arrays.stream(nums).sum();

        if ((sum & 1) == 1) {
            return false;
        }
        int part = sum / 2;
       // 表示从数组的 [0, i] 这个子区间内挑选一些正整数，每个数只能用一次，使得这些数的和等于 j。
        boolean [][] dp=new boolean[nums.length][part+1];
        for (int i = 0; i <= part; i++) {
            if (nums[0]==i){
                dp[0][i]=true;
            }
        }
        for (int row = 1; row <nums.length ; row++) {
            for (int column = 0; column <=part ; column++) {
              if (nums[row]>=column){
                  dp[row][column]=dp[row-1][column];
              }else {
                  dp[row][column]=false;

              }
            }
        }

        return true;

    }
}
