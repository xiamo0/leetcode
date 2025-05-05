package dp;

/**
 * https://leetcode.cn/problems/edit-distance/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class EditDistance {
    public static void main(String[] args) {
        String word1 = "";
        String word2 = "";
        System.out.println(new EditDistance().minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {

        //将 word1 的前 i 个字符转换为 word2 的前 j 个字符所需的最少操作数为 dp[i][j]
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <=word1.length() ; i++) {
            dp[i][0]=i;
        }
        for (int i = 0; i <=word2.length() ; i++) {
            dp[0][i]=i;
        }
        for (int i = 1; i <=word1.length() ; i++) {
            for (int j = 1; j <=word2.length() ; j++) {
                if (word1.charAt(i-1)== word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=1+Math.min(dp[i][j-1],
                            Math.min(dp[i-1][j],dp[i-1][j-1]));
                }
            }
        }
        return dp[word1.length()][word2.length()];

    }
}
