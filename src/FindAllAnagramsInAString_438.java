import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/?envType=problem-list-v2&envId=2cktkvj
 */
public class FindAllAnagramsInAString_438 {


    public static void main(String[] args) {
        FindAllAnagramsInAString_438 aString438 = new FindAllAnagramsInAString_438();
        String s="cbaebabacd";
        String p="abc";
        System.out.println(aString438.findAnagrams(s,p));

    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> r = new ArrayList<>();
        String longStr = s;
        String shortStr = p;
        if (longStr.length() < shortStr.length()) {
            return r;
        }
        if (longStr.equals(shortStr)){
            return r;
        }
        for (int i = 0; i < longStr.length(); i++) {
            List<String> list = Arrays.stream(shortStr.split("")).collect(Collectors.toList());
            int interval=0;
            for (int i1 = 0; i1 < shortStr.length(); i1++) {
                int curIndex=i + interval;
                interval+=1;
                if (curIndex>=longStr.length()){
                    break;
                }
                char c = longStr.charAt(curIndex);
                list.remove(String.valueOf(c));
            }
            if (list.isEmpty()){
                r.add(i);
            }
        }
        return r;
    }
}
