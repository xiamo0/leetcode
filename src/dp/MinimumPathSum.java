package dp;

/**
 * https://leetcode.cn/problems/minimum-path-sum/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class MinimumPathSum {

    public static void main(String[] args) {
        MinimumPathSum minimumPathSum = new MinimumPathSum();
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1},
        };
        System.out.println(minimumPathSum.minPathSum(grid));

    }

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[row][column];
        dp[0][0] = grid[0][0];
        for (int curColumn = 1; curColumn < column; curColumn++) {
            dp[0][curColumn] = dp[0][curColumn - 1] + grid[0][curColumn];
        }
        for (int curRow = 1; curRow < row; curRow++) {
            dp[curRow][0] = dp[curRow - 1][0] + grid[curRow][0];
        }
        for (int curRow = 1; curRow < row; curRow++) {
            for (int curColumn = 1; curColumn < column; curColumn++) {
                dp[curRow][curColumn] = Math.min(dp[curRow - 1][curColumn], dp[curRow][curColumn - 1]) + grid[curRow][curColumn];
            }
        }
        return dp[row-1][column-1];
    }

}
