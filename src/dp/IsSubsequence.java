package dp;

/**
 * https://leetcode.cn/problems/is-subsequence/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class IsSubsequence {

    public static void main(String[] args) {

        String s = "abc";
        String t = "ahbgdc";
        s = "axc";
        t = "ahbgdc";
        s = "aaaaaa";
        t = "bbaaaa";
//        s="abc";
//        t="ahbgdc";
        System.out.println(new IsSubsequence().isSubsequence(s, t));
    }

    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        int[] dp = new int[s.length()];
        dp[0] = find(t, s.charAt(0), 0);
        for (int i = 1; i < dp.length; i++) {
            char c = s.charAt(i);
            dp[i] = find(t, c, dp[i - 1]+1);
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == Integer.MIN_VALUE) {
                return false;
            }
        }
        return true;
    }

    public int find(String t, char targetChar, int beginIndex) {
        if (beginIndex <0) {
            return beginIndex;
        }
        for (int i = beginIndex ; i < t.length(); i++) {
            if (t.charAt(i) == targetChar) {
                return i;
            }
        }
        return Integer.MIN_VALUE;
    }
}
