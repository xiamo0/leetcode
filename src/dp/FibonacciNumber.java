package dp;

/**
 * https://leetcode.cn/problems/fibonacci-number/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class FibonacciNumber {

    public static void main(String[] args) {
        int n=4;
        System.out.println(new FibonacciNumber().fib(n));
    }
    public int fib(int n) {
        if (n<=1){
            return n;
        }
        int[]dp=new int[n+1];
        dp[1]=1;
        for (int i = 2; i <dp.length ; i++) {
            dp[i]=dp[i-2]+dp[i-1];
        }
        return dp[n];

    }
}
