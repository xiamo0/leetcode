package hashtable;

/*
https://leetcode.cn/problems/longest-substring-without-repeating-characters/?envType=problem-list-v2&envId=hash-table
无重复字符的最长子串
给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。



示例 1:

输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

提示：

0 <= s.length <= 5 * 104
s 由英文字母、数字、符号和空格组成
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * 这段代码实现了“无重复字符的最长子串”问题的滑动窗口解法：
     *
     * - `charIndex` 数组记录每个 ASCII 字符上一次出现的位置（加 1，避免与默认值 0 混淆）。
     * - `left` 表示当前窗口的左边界。
     * - 遍历字符串，每遇到重复字符就移动左边界到重复字符的下一个位置。
     * - 每次更新最大子串长度 `maxLength`。
     *
     * 这样可以高效地找到最长无重复子串的长度，时间复杂度为 O\(n\)。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int left = 0;
        int[] charIndex = new int[128]; // ASCII字符集

        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            if (charIndex[currentChar] > left) {
                // 如果当前字符在左边界右侧出现过，更新左边界
                left = charIndex[currentChar];
            }
            charIndex[currentChar] = right + 1; // 更新字符的最新索引
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;

    }
}
