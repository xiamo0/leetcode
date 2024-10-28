/**
 * https://leetcode.cn/problems/maximal-square/description/?envType=problem-list-v2&envId=2cktkvj
 */
public class MaximalSquare_221 {
    //todo
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        int rowLength = matrix.length;
        int columLength = matrix[0].length;
        int[][] dp = new int[rowLength][columLength];
        for (int curRow = 0; curRow < rowLength; curRow++) {
            for (int curCol = 0; curCol < columLength; curCol++) {
                if (matrix[curRow][curCol]=='1'){
                    if (curCol==0){
                        dp[curRow][curCol]=1;
                    }else{
                        dp[curRow][curCol]=dp[curRow][curCol-1]+1;
                    }
                }else {
                    dp[curRow][curCol]=0;
                }
            }
        }
        return maxSide * maxSide;

    }


    public int maximalSquare1(char[][] matrix) {

        int height = matrix.length;
        int width = matrix[0].length;
        int maxSide = 0;

        //dp[i][j]表示 以 matrix[i][j]为右下角的正方形的边长长度，
        int[][] dp = new int[height][width];

        for (int curRow = 0; curRow < height; curRow++) {
            for (int curColumn = 0; curColumn < width; curColumn++) {
                if (matrix[curRow][curColumn] == '1') {
                    if (curRow == 0 || curColumn == 0) {
                        dp[curRow][curColumn] = 1;
                    } else {
                        dp[curRow][curColumn] = Math.min(Math.min(dp[curRow - 1][curColumn], dp[curRow ][curColumn-1]), dp[curRow - 1][curColumn - 1]) + 1;
                    }
                    maxSide = Math.max(dp[curRow][curColumn], maxSide);
                }
            }
        }
        return maxSide * maxSide;
    }


}
