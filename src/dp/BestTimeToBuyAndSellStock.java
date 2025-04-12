package dp;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        System.out.println(bestTimeToBuyAndSellStock.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        // 第i天卖出的最大利润  dp[i]=max(dp[i-1],prices[i]-(prices[0..i-1]中的最小值))
        int length = prices.length;
        int[] dpMax = new int[length];
        int min = prices[0];
        for (int i = 1; i < length; i++) {
            min = Math.min(min, prices[i]);
            dpMax[i] = Math.max(dpMax[i - 1], prices[i] - min);
        }
        return dpMax[length - 1];
    }
}
