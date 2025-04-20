package dp;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/can-i-win/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class CanIWin {

    public static void main(String[] args) {

        int maxChoosableInteger = 10;
        int desiredTotal = 40;
        System.out.println(new CanIWin().canIWin(maxChoosableInteger, desiredTotal));
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        int[] dp = new int[desiredTotal+1];
        Arrays.fill(dp,0,maxChoosableInteger+1,1);

        for (int i = maxChoosableInteger+1; i < dp.length; i++) {
            if (dp[i-1]==1){
                dp[i]=1;
            }else{
                dp[i]
            }
        }
        return false;
    }

}
