package dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.cn/problems/generate-parentheses/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        System.out.println(generateParentheses.generateParenthesis(3));

    }

    public List<String> generateParenthesis(int n) {
        List<Set<String>> dp = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            Set<String> list = new HashSet<>();
            dp.add(list);
            if (i == 0) {
                list.add("");
            }else {
                //p + q = n - 1
                for (int p = 0; p <i ; p++) {
                    int q=i-1-p;

                    Set<String> leftList = dp.get(p);
                    Set<String> rightList = dp.get(q);
                    for (String left : leftList) {
                        for (String right : rightList) {
                            String temp="("+left+")"+right;
                            list.add(temp);
                        }
                    }
                }
            }
        }
        return  new ArrayList<>(dp.get(n));
    }
}
