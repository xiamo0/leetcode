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
        if ((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }

        return false;
    }

}
