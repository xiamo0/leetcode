package dp;

/**
 * https://leetcode.cn/problems/jump-game/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class JumpGame {

    public static void main(String[] args) {
        int[] nums = {0, 2, 3};
        System.out.println(new JumpGame().canJump(nums));
    }

    public boolean canJump1(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) {
                return false;
            }
            farthest = Math.max(farthest, i + nums[i]);
        }
        return true;
    }

    public boolean canJump(int[] nums) {

        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int maxStep = nums[j];
                if (maxStep + j >= i && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];

    }

}
