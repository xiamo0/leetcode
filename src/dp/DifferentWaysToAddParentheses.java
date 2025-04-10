package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/different-ways-to-add-parentheses/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class DifferentWaysToAddParentheses {

    Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                String leftExpression = expression.substring(0, i);
                String rightExpression = expression.substring(i + 1);
                List<Integer> leftList = diffWaysToCompute(leftExpression);
                List<Integer> rightList = diffWaysToCompute(rightExpression);
                for (Integer left : leftList) {
                    for (Integer right : rightList) {
                        int value = 0;
                        switch (c) {
                            case '+': {
                                value = left + right;
                                break;
                            }
                            case '-': {
                                value = left - right;
                                break;
                            }
                            case '*': {
                                value = left * right;
                                break;
                            }
                            case '/': {
                                value = left / right;
                                break;
                            }
                            default:
                                break;
                        }
                        result.add(value);

                    }
                }
            }
        }
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }
        memo.put(expression, result);
        return result;
    }

    public static void main(String[] args) {
        DifferentWaysToAddParentheses differentWaysToAddParentheses = new DifferentWaysToAddParentheses();
        List<Integer> list = differentWaysToAddParentheses.diffWaysToCompute("2-1-1");
        System.out.println(list);
    }
}
