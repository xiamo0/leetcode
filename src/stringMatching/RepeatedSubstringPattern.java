package stringMatching;

/**
 * 重复的子字符串
 * https://leetcode.cn/problems/repeated-substring-pattern/description/?envType=problem-list-v2&envId=string-matching
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abab"
 * 输出: true
 * 解释: 可由子串 "ab" 重复两次构成。
 * 示例 2:
 * <p>
 * 输入: s = "aba"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: s = "abcabcabcabc"
 * 输出: true
 * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
 */
public class RepeatedSubstringPattern {

    public boolean repeatedSubstringPattern(String s) {
        return (s + s).substring(1, s.length() * 2 - 1).contains(s);

    }
}
