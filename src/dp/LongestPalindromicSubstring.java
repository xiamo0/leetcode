package dp;

/**
 * https://leetcode.cn/problems/longest-palindromic-substring/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "babad";
        // s="cbbd";
//        s = "aaa";
        LongestPalindromicSubstring substring = new LongestPalindromicSubstring();
        System.out.println(substring.longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }
        //dp[i][j]表示 i 到 j 是否是回文
        boolean[][] dp = new boolean[length][length];
        int start = 0;
        int maxLength = 1;
        /*for (int i = 0; i < length; i++) {
            dp[i][i] = true;
            for (int j = i + 1; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if ((j == (i + 1)) || (dp[i + 1][j - 1])) {
                        dp[i][j] = true;
                        if (j - i + 1 > maxLength) {
                            start = i;
                            maxLength = j - i + 1;
                        }
                    }
                }
            }
        }*/
        for (int i = length - 1; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        if (j - i + 1 > maxLength) {
                            start = i;
                            maxLength = j - i + 1;
                        }
                    }
                }

            }
        }
        String substring = s.substring(start, start + maxLength);
        return substring;
    }

    public static int[][] calcDp(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];
        dp[0][0] = 1;
        for (int j = 1; j < length; j++) {
            if (isHuiwen(s, 0, j)) {
                dp[0][j] = j + 1;
            }
            dp[0][j] = Math.max(dp[0][j - 1], dp[0][j]);
            if (dp[0][j] == length) {
                return dp;
            }
        }

        for (int i = 1; i < length; i++) {
            // 如果当前 开始的 的最大长度 小于之前的存在的长度 就结束
            int curMaxLen = length - i;
            for (int j = 0; j < i; j++) {
                if (maxNum(dp[j]) >= curMaxLen) {
                    return dp;
                }
            }
            dp[i][i] = 1;
            for (int j = i + 1; j < length; j++) {
                if (isHuiwen(s, i, j)) {
                    dp[i][j] = j - i + 1;
                }
                dp[i][j] = Math.max(dp[i][j - 1], dp[i][j]);
            }
        }
        return dp;
    }

    public String longestPalindrome2(String s) {

        int[][] dp = calcDp(s);
        String subStr = "";
        for (int i = 0; i < dp.length; i++) {
            int curMax = maxNum(dp[i]);
            if (subStr.length() < curMax) {
                subStr = s.substring(i, curMax + i);
            }
        }
        return subStr;
    }

    public static int maxNum(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }

    public String longestPalindrome1(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];

        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
            for (int j = i + 1; j < length; j++) {
                if (isHuiwen(s, i, j)) {
                    dp[i][j] = j - i + 1;
                }
                dp[i][j] = Math.max(dp[i][j - 1], dp[i][j]);
            }
        }
        String subStr = "";
        for (int i = 0; i < length; i++) {
            int[] ints = dp[i];
            int curMax = ints[0];
            for (int i1 = 0; i1 < ints.length; i1++) {
                if (curMax < ints[i1]) {
                    curMax = ints[i1];
                }
            }
            if (subStr.length() < curMax) {
                subStr = s.substring(i, curMax + i);
            }
        }
        return subStr;
    }

    private static boolean isHuiwen(String str, int beginIndex, int endIndex) {
        char[] charArray = str.toCharArray();
        while (beginIndex <= endIndex) {
            if (charArray[beginIndex] != charArray[endIndex]) {
                return false;
            }
            beginIndex++;
            endIndex--;
        }
        return true;
    }
}
/**
 * 1.	判断是否适用 DP（最优子结构+重叠子问题）
 * 2.	定义状态 dp[i]
 * dp[i][j] 表示 下标 i 到 j 之间 最大的回文长度
 * 3.	写出状态转移方程
 * dp[i][j] =max(dp[i][j-1],dp[i][j])
 * 4.	初始化
 * 0=< i <= j <= str.len+1
 * dp[0][0]=0
 * dp[i][i]=1
 * 5.	确定遍历顺序
 * 6.	处理边界情况
 * 7.	优化（空间压缩、二分、矩阵快速幂）
 */
