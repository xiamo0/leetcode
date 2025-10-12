package stringMatching;

/**
 * https://leetcode.cn/problems/rotate-string/description/?envType=problem-list-v2&envId=string-matching
 * 给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。
 *
 * s 的 旋转操作 就是将 s 最左边的字符移动到最右边。
 *
 * 例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。
 *
 *
 * 示例 1:
 *
 * 输入: s = "abcde", goal = "cdeab"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "abcde", goal = "abced"
 * 输出: false
 */
public class RotateString {

    public boolean rotateString(String s, String goal) {

        if (s.length() != goal.length()) {
            return false;
        }
        String ss = s + s;
        return ss.contains(goal);
    }
}
