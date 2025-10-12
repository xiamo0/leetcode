package stringMatching;

import java.util.List;

/**
 * https://leetcode.cn/problems/camelcase-matching/?envType=problem-list-v2&envId=string-matching
 * 给你一个字符串数组 queries，和一个表示模式的字符串 pattern，请你返回一个布尔数组 answer 。只有在待查项 queries[i] 与模式串 pattern 匹配时， answer[i] 才为 true，否则为 false。
 *
 * 如果可以将 小写字母 插入模式串 pattern 得到待查询项 queries[i]，那么待查询项与给定模式串匹配。您可以在模式串中的任何位置插入字符，也可以选择不插入任何字符。
 *
 *
 *
 * 示例 1：
 *
 * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
 * 输出：[true,false,true,true,false]
 * 示例：
 * "FooBar" 可以这样生成："F" + "oo" + "B" + "ar"。
 * "FootBall" 可以这样生成："F" + "oot" + "B" + "all".
 * "FrameBuffer" 可以这样生成："F" + "rame" + "B" + "uffer".
 * 示例 2：
 *
 * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
 * 输出：[true,false,true,false,false]
 * 解释：
 * "FooBar" 可以这样生成："Fo" + "o" + "Ba" + "r".
 * "FootBall" 可以这样生成："Fo" + "ot" + "Ba" + "ll".
 * 示例 3：
 *
 * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
 * 输出：[false,true,false,false,false]
 * 解释：
 * "FooBarTest" 可以这样生成："Fo" + "o" + "Ba" + "r" + "T" + "est".
 *
 */
public class CamelcaseMatching {
    public List<Boolean> camelMatch(String[] queries, String pattern) {

        String regexP="^[a-z]*";
        for (String s : pattern.split("")) {
            regexP+=s;
            regexP+="[a-z]*";
        }
        regexP+="$";
        String finalRegexP = regexP;
        return  java.util.Arrays.stream(queries).map(q->q.matches(finalRegexP)).toList();

    }
}
