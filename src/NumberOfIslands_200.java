/**
 * https://leetcode.cn/problems/number-of-islands/description/?envType=problem-list-v2&envId=2cktkvj
 */
public class NumberOfIslands_200 {
    public int numIslands(char[][] grid) {

        int num=0;
        int rowLength = grid.length;
        int columnLength = grid[0].length;
        for (int row = 0; row <rowLength ; row++) {
            for (int column = 0; column < columnLength; column++) {
                if (grid[row][column]=='1'){
                    num++;
                    scan(row,column,grid);

                }
            }

        }

        return num;
    }
    public static void scan(int row,int column,char[][] grid) {

        int rowLength = grid.length;
        int columnLength = grid[0].length;
        int nextColumn = column+1;
        int nextRow = row+1;
        int prevColumn = column-1;
        int prevRow = row-1;

        if (prevRow>=0 && grid[prevRow][column]=='1'){
            grid[prevRow][column]='0';
            scan(prevRow,column,grid);
        }
        if (nextColumn<columnLength && grid[row][nextColumn] =='1'){
            grid[row][nextColumn] ='0';
            scan(row,nextColumn,grid);
        }
        if (nextRow<rowLength && grid[nextRow][column]=='1'){
            grid[nextRow][column]='0';
            scan(nextRow,column,grid);
        }
        if (prevColumn>=0 && grid[row][prevColumn]=='1'){
            grid[row][prevColumn]='0';
            scan(row,prevColumn,grid);
        }
    }

}
