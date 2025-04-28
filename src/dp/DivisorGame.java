package dp;

/**
 * https://leetcode.cn/problems/divisor-game/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class DivisorGame {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(new DivisorGame().divisorGame(n));
        System.out.println(new DivisorGame().divisorGame1(n));
    }

    public boolean divisorGame(int n) {
        boolean[] dp = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i && !dp[i]; j++) {
                if (i % j == 0 ) {
                    dp[i] = !dp[i-j];
                }
            }
        }
        return dp[n];

    }

    public static boolean divisorGame1(int N) {
        // 创建一个布尔数组 dp，长度为 N+1
        boolean[] dp = new boolean[N + 1];
        // 遍历从 1 到 N 的每一个数，计算 dp[i]
        for (int i = 1; i <= N; i++) {
            // 尝试所有可能的 x
            for (int x = 1; x < i && !dp[i]; x++) {
                if (i % x == 0) {
                    dp[i] = !dp[i - x];
                }
            }
        }

        return dp[N];
    }

}
