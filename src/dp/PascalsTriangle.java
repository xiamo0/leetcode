package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/pascals-triangle/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        PascalsTriangle pascalsTriangle = new PascalsTriangle();
        System.out.println(pascalsTriangle.generate(5));

    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> pre = (i - 1 >= 0) ? result.get(i - 1) : null;
            result.add(dp(i, pre));
        }
        return result;
    }

    List<Integer> dp(int row, List<Integer> pre) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < row+1; i++) {
            if (pre == null || (i - 1) < 0 || i >= pre.size()) {
                result.add(1);
            } else {
                result.add(pre.get(i - 1) + pre.get(i));
            }
        }
        return result;
    }
}
