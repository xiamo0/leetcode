import java.util.*;
import java.util.stream.Collectors;


/**
 * 题目：前K个高频单词
 * 给定一个单词列表 words 和一个整数 k ，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序 排序。
 * 示例1
 * <p>
 * 输入: words = ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 * 注意，按字母顺序 "i" 在 "love" 之前。
 * 示例 2：
 * <p>
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 * 出现次数依次为 4, 3, 2 和 1 次。
 * 注意：
 * 1 <= words.length <= 500
 * 1 <= words[i] <= 10
 * words[i] 由小写英文字母组成。
 * k 的取值范围是 [1, 不同 words[i] 的数量]
 */
public class TopKFrequent {

    public static void main(String[] args) {
        TopKFrequent main = new TopKFrequent();
        String[] words4 = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        String[] words2=new String[] {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println( main.topKFrequent(words2, 2).stream().collect(Collectors.joining(",")));
        System.out.println( main.topKFrequent(words4, 4).stream().collect(Collectors.joining(",")));
    }

    public List<String> topKFrequent(String[] words, int k) {

        if (words == null || words.length == 0) {
            return null;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        List<String> result = new ArrayList<>();
        List<Integer> collect = map.values().stream().sorted((a, b) -> {
            return b - a;
        }).limit(k).collect(Collectors.toList());

        List<Integer>collect1=new ArrayList<>();
        for (int i = 0; i < collect.size(); i++) {
            if (collect1.contains(collect.get(i))){

            }else{
                collect1.add(collect.get(i));
            }
        }



        for (Integer integer : collect1) {
            Set<String> keys = map.entrySet().stream().filter(e -> {
                if (e.getValue().intValue() == integer.intValue()) {
                    return true;
                } else {
                    return false;
                }
            }).map(e -> {
                return e.getKey();
            }).collect(Collectors.toSet());
            Queue<String> temp = new PriorityQueue<>();
            temp.addAll(keys);
            result.addAll(temp);
        }
        return result;

    }
}
