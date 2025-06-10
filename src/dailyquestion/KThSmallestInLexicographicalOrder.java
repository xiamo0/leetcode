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


字典具体规则：
	•	先比较字符串第一个字符，哪个字符的编码（ASCII 或 Unicode）小，哪个字符串就排在前面。
	•	如果第一个字符相同，再比较第二个字符，以此类推。
	•	如果一个字符串是另一个字符串的前缀，短的那个排在前面。
 */
public class KThSmallestInLexicographicalOrder {

    public int findKthNumber(int n, int k) {
        int curr = 1;
        k--; // 第一个数字是1，我们已经在1了

        while (k > 0) {
            long steps = getSteps(n, curr, curr + 1); // 在字典树中，从curr到curr+1之间有多少个数
            if (steps <= k) {
                // 跳过这批前缀，往右兄弟节点走
                curr++;
                k -= steps;
            } else {
                // 进入子节点（扩大前缀）
                curr *= 10;
                k--;
            }
        }
        return curr;
    }

    // 计算以prefix为前缀，在[n]内有多少个数字
    private long getSteps(int n, long prefix, long nextPrefix) {
        long steps = 0;
        while (prefix <= n) {
            steps += Math.min(n + 1, nextPrefix) - prefix;
            prefix *= 10;
            nextPrefix *= 10;
        }
        return steps;
    }

    public static int findKthNumber1(int n, int k) {

        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(String.valueOf(i));
        }
        list.sort(String::compareTo);
        return Integer.parseInt(list.get(k - 1));
    }
}
