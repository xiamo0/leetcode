package hashtable;

import java.util.HashMap;

/*
https://leetcode.cn/problems/valid-anagram/?envType=problem-list-v2&envId=hash-table
有效的字母异位词
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的 字母异位词。



示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false; // 长度不同，直接返回false
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String charS = String.valueOf(s.charAt(i));
            String charT = String.valueOf(t.charAt(i));

            map.put(charS, map.getOrDefault(charS, 0) + 1);
            map.put(charT, map.getOrDefault(charT, 0) - 1);
        }
        long count = map.values().stream().filter(v -> v != 0).count();
        return count == 0;


    }

}
