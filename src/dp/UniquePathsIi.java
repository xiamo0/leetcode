package dp;

/**
 * https://leetcode.cn/problems/unique-paths-ii/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class UniquePathsIi {

    public static void main(String[] args) {
        UniquePathsIi uniquePathsIi = new UniquePathsIi();
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePathsIi.uniquePathsWithObstacles(obstacleGrid));

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        int[][] dp = new int[row][column];

        if (obstacleGrid[0][0] == 0) {
            dp[0][0] = 1;
        }
        for (int curColumn = 1; curColumn < column; curColumn++) {
            if (obstacleGrid[0][curColumn] == 1 || dp[0][curColumn - 1] == 0) {
                dp[0][curColumn] = 0;
            } else {
                dp[0][curColumn] = 1;
            }
        }
        for (int curRow = 1; curRow < row; curRow++) {
            if (obstacleGrid[curRow][0] == 1 || dp[curRow - 1][0] == 0) {
                dp[curRow][0] = 0;
            } else {
                dp[curRow][0] = 1;
            }
        }
        for (int curRow = 1; curRow < row; curRow++) {
            for (int curColumn = 1; curColumn < column; curColumn++) {
                if (obstacleGrid[curRow][curColumn] == 1) {
                    dp[curRow][curColumn] = 0;
                    continue;
                }
                dp[curRow][curColumn] = dp[curRow - 1][curColumn] + dp[curRow][curColumn - 1];
            }
        }
        return dp[row - 1][column - 1];
    }

}
