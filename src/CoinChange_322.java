import java.util.Arrays;

/**
 * https://leetcode.cn/problems/coin-change/description/?envType=problem-list-v2&envId=2cktkvj
 */
public class CoinChange_322 {

    public static void main(String[] args) {
        CoinChange_322 change322 = new CoinChange_322();
        int[] coins = {186, 419, 83, 408};
        coins = new int[]{186, 419, 83, 408};
//        System.out.println(change322.coinChange(coins, 6249));
        System.out.println(Math.ceilDiv(10, 3));
    }

    public int coinChange(int[] coins, int amount) {

        Arrays.sort(coins);
        int copyAmount = amount;

        int minCount = Math.ceilDiv(amount, coins[coins.length - 1]);
        int maxCount = Math.ceilDiv(amount, coins[0]);
        int finalCount = minCount;
        int curCoinIndex = coins.length - 1;
        for (int curCount = minCount; curCount <= maxCount; curCount++) {
            copyAmount = amount;
            if (curCount == minCount) {
                boolean b = copyAmount - curCount * coins[curCoinIndex] == 0;
                if (b) {
                    return curCount;
                }
            }
            if (curCount == maxCount) {
                boolean b = copyAmount - curCount * coins[0] == 0;
                if (b) {
                    return curCount;
                }
            }
            int subCount = curCount - minCount;
            while (subCount!=0){
                int tempMinCount=minCount-1;
                int tempMinCountIndex=coins.length-1;
                copyAmount=copyAmount-tempMinCount*coins[tempMinCountIndex];

            }






        }


        return finalCount;
    }
}
