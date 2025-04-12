package dp;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class BestTimeToBuyAndSellStock2 {

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock2 bestTimeToBuyAndSellStock2 = new BestTimeToBuyAndSellStock2();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(bestTimeToBuyAndSellStock2.maxProfit(prices));

    }

    public int maxProfit(int[] prices) {
        //dp[i] 0到 i 天 的最大利润
        //第1天的最大利润dp[0]=0
        //第2天的最大利润 dp[1]= max(前1天的最大利润，(第一天买 第二天卖 的利润))
        //第3天的最大利润 dp[2]= max((第一天买 第三天卖 的利润)，（第一天的最大利润+第2天买，第3天卖的利润），（前2天的最大利润 + 第三天买卖的利润）)
        //第4天的最大利润 dp[3]=max(（第1天买 第4天 卖的利润），（前1天的最大利润 + 第2天买第4天卖的利润），（前2天的最大利润+第3天买第4天卖的利润），（前3天的最大利润+第4天买卖的利润）)
        int rowLen = prices.length;
        int[] dp = new int[rowLen];
        for (int i = 1; i < rowLen; i++) {
            //第0天买 第i天卖的利润
            dp[i] = prices[i] - prices[0];
            for (int j = 1; j <= i; j++) {
                int i1 = prices[i] - prices[j] + dp[j - 1];
                dp[i] = Math.max(i1, dp[i]);
            }
        }
        return dp[dp.length - 1];
    }


}
