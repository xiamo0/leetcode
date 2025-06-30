package hashtable;

import java.util.HashMap;

/*
https://leetcode.cn/problems/word-pattern/description/?envType=problem-list-v2&envId=hash-table
单词规律
给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。

这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。



示例1:

输入: pattern = "abba", s = "dog cat cat dog"
输出: true
示例 2:

输入:pattern = "abba", s = "dog cat cat fish"
输出: false

 */
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] split = pattern.split("");
        String[] split1 = s.split(" ");
        if (split.length != split1.length) {
            return false; // 长度不同，直接返回false
        }
        HashMap<String, String> map = new HashMap<>();
        for (int i1 = 0; i1 < split.length; i1++) {
            String s1 = split[i1];
            String s2 = split1[i1];
            String s3 = map.get(s1);
            if (s3==null && map.containsValue(s2)){
                return false; // 如果s2已经被其他s1映射，返回false
            }
            if (s3==null){
                map.put(s1, s2);
                continue;
            }
            if (!s3.equals(s2)) {
                return false; // 如果映射不一致，返回false
            }

        }
        return true;

    }
}
