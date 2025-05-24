package bitmanipulation;

/*
https://leetcode.cn/problems/power-of-two/description/?envType=problem-list-v2&envId=bit-manipulation

给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。

如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。



示例 1：

输入：n = 1
输出：true
解释：20 = 1
示例 2：

输入：n = 16
输出：true
解释：24 = 16
示例 3：

输入：n = 3
输出：false


提示：

-231 <= n <= 231 - 1
 */
public class PowerOfTwo {
    public static void main(String[] args) {
        new PowerOfTwo().isPowerOfTwo(1073741825);
    }

    public boolean isPowerOfTwo(int n) {
        // 100 101 110
        // 001 001
        //
        if (n<0){
            return false;
        }
        return Integer.bitCount(n)==1;



    }
}
