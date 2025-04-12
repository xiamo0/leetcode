package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/pascals-triangle-ii/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class PascalsTriangle2 {
    public static void main(String[] args) {
        PascalsTriangle2 triangle2 = new PascalsTriangle2();
        System.out.println(triangle2.getRow(3));
    }

    public List<Integer> getRow(int rowIndex) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> list = map.get(i - 1);
            map.put(i, dp(i, list));
        }
        return map.get(rowIndex);
    }

    public List<Integer> dp(int rowIndex, List<Integer> pre) {
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        if (pre == null) {
            result.add(1);
            return result;
        }
        for (int i = 0; i <= rowIndex; i++) {
            if (i == 0 || i == (rowIndex)) {
                result.add(1);
            } else {
                result.add(pre.get(i - 1) + pre.get(i));
            }
        }
        return result;
    }
}
