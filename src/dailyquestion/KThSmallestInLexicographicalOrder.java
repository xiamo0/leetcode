package dailyquestion;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.cn/problems/k-th-smallest-in-lexicographical-order/description/?envType=daily-question&envId=2025-06-09
字典序的第K小数字

给定整数 n 和 k，返回  [1, n] 中字典序第 k 小的数字。
示例 1:

输入: n = 13, k = 2
输出: 10
解释: 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
示例 2:

输入: n = 1, k = 1
输出: 1
 */
public class KThSmallestInLexicographicalOrder {

    public int findKthNumber1(int n, int k) {

        List<String> list=new ArrayList<>();
        for (int i = 1; i <=n ; i++) {
            list.add(String.valueOf(i));
        }
        list.sort(String::compareTo);
        return Integer.parseInt(list.get(k-1));
    }
}
