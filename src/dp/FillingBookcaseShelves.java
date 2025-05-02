package dp;

/**
 * https://leetcode.cn/problems/filling-bookcase-shelves/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class FillingBookcaseShelves {

    public static void main(String[] args) {
        int[][] books = {
                {1, 3}, {2, 4}, {3, 2}
        };
        books = new int[][]{{7, 3}, {8, 7}, {2, 7}, {2, 5}};
        int shelfWidth = 10;
        System.out.println(new FillingBookcaseShelves().minHeightShelves(books, shelfWidth));
        System.out.println(new FillingBookcaseShelves().minHeightShelves1(books, shelfWidth));
    }

    public int minHeightShelves1(int[][] books, int shelfWidth) {
        //前i 本书 的最小高度是 dp[i]
        int[] dp = new int[books.length + 1];
        for (int i = 1; i < dp.length; i++) {
            int maxHeight=0;
            int totalThickness=0;
            dp[i]=Integer.MAX_VALUE;
            for (int j = i; j >=1 ; j--) {
                totalThickness +=books[j-1][0];
                if (totalThickness>shelfWidth){
                    break;
                }
                maxHeight=Math.max(maxHeight,books[j-1][1]);
                dp[i]=Math.min(dp[i],dp[j-1]+maxHeight);
            }
        }
        return dp[dp.length - 1];
    }


    public int minHeightShelves(int[][] books, int shelfWidth) {
        //前i 本书 的最小高度是 dp[i]
        int[] dp = new int[books.length + 1];
        for (int i = 1; i < dp.length; i++) {
            int totalWidth = shelfWidth;
            for (int j = i; j > 0; j--) {
                int thickness = books[j - 1][0];
                int height = books[j - 1][1];
                totalWidth -= thickness;
                if (totalWidth >= 0) {
                    dp[i] = Math.max(dp[i], height);
                } else {
                    dp[i] = dp[i] + dp[j];
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }

}
