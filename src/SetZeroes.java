import java.util.*;

/**
 * https://leetcode.cn/problems/set-matrix-zeroes/?envType=study-plan-v2&envId=top-100-liked
 */
public class SetZeroes {

    public static void main(String[] args) {

//      int[][]  matrix = {{1,1,1},{1,0,1},{1,1,1}};
        int[][]     matrix={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
      new SetZeroes().setZeroes(matrix);
    }

    public void setZeroes(int[][] matrix) {

        int row = matrix.length;
        int column = matrix[0].length;
        List<Integer> target=new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j]==0){
                    target.add(i);
                    target.add(j);

                }
            }
        }
        for (int i = 0; i < target.size(); i=i+2) {
            int curRow=target.get(i);
            int curColumn=target.get(i+1);
            setRowZero(matrix,curRow);
            setColumnZero(matrix,curColumn);

        }
        System.out.println();
    }

    public void setRowZero(int[][] matrix, int row) {
        for (int i = 0; i < matrix[row].length; i++) {
            matrix[row][i] = 0;
        }
    }

    public void setColumnZero(int[][] matrix, int column) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }
    }

}
