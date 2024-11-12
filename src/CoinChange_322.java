import java.util.Arrays;

/**
 * https://leetcode.cn/problems/coin-change/description/?envType=problem-list-v2&envId=2cktkvj
 */
public class CoinChange_322 {

    public static void main(String[] args) {
        CoinChange_322 change322 = new CoinChange_322();
        int[] coins = {186, 419, 83, 408};
        coins = new int[]{2};
        System.out.println(change322.coinChange(coins, 3));
//        System.out.println(Math.ceilDiv(10, 3));
    }

    public int coinChange(int[] coins, int amount) {

        if (amount==0){
            return 0;
        }
        //凑足 金额 i  所需金币数量为 dp[i]
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount+1;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }


        return dp[amount] != (amount+1) ? dp[amount] : -1;

    }
}
