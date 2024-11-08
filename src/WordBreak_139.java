import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * https://leetcode.cn/problems/word-break/description/?envType=problem-list-v2&envId=2cktkvj
 */
public class WordBreak_139 {

    public static void main(String[] args) {
        String s = "leetcode";
        String[] wordDict = {"leet", "code"};
        System.out.println(wordBreak(s, Arrays.stream(wordDict).toList()));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {

        if (s == null || wordDict == null || wordDict.size() == 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                String substring = s.substring(j, i);
                if (dp[j] == 1 && wordDict.contains(substring)) {
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[chars.length]==1;
    }
}
