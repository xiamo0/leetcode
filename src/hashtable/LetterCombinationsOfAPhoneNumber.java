package hashtable;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.cn/problems/letter-combinations-of-a-phone-number/?envType=problem-list-v2&envId=hash-table
电话号码的字母组合
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

 */
public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber solution = new LetterCombinationsOfAPhoneNumber();
        String digits = "23";
        List<String> combinations = solution.letterCombinations(digits);
        System.out.println(combinations); // 输出: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
    }
    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) {
            return List.of(); // 返回空列表
        }

        String[] digitToLetters = {
                "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        List<String> result = new ArrayList<>();
        char[] charArray = digits.toCharArray();
        for (int i1 = 0; i1 < charArray.length; i1++) {
            int i11 = charArray[i1]-'0';
            String digitToLetter = digitToLetters[i11];
            result=result(digitToLetter, result);
        }
        return result;
    }
    static List<String> result(String str, List<String> pre) {
        List<String> result = new ArrayList<>();
        for (char c : str.toCharArray()) {
            if (!pre.isEmpty()) {
                for (String s : pre) {
                    result.add(s + c);
                }
            } else {
                result.add(String.valueOf(c));
            }
        }
        return result;
    }

    static List<String> backtrack(String digits, String[] digitToLetters, int index, StringBuilder currentCombination, List<String> result) {
        if (index == digits.length()) {
            result.add(currentCombination.toString());
            return result;
        }

        char digit = digits.charAt(index);
        String letters = digitToLetters[digit - '0'];

        for (char letter : letters.toCharArray()) {
            currentCombination.append(letter);
            backtrack(digits, digitToLetters, index + 1, currentCombination, result);
            currentCombination.deleteCharAt(currentCombination.length() - 1); // 回溯
        }

        return result;
    }

}
