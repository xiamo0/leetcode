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
        String s="abab";
        String p="ab";
        System.out.println(aString438.findAnagrams(s,p));

    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> r=new ArrayList<>();
        if (s.length()<p.length()){
            return r;
        }
        int[]sCharCount=new int[26];
        int[]pCharCount=new int[26];
        for (int i = 0; i <p.length() ; i++) {
            sCharCount[s.charAt(i)-'a']+=1;
            pCharCount[p.charAt(i)-'a']+=1;
        }
        if (Arrays.equals(sCharCount,pCharCount)){
            r.add(0);
        }

        for (int i = 1; i <= s.length()-p.length(); i++) {
            sCharCount=new int[26];
            for (int j = 0; j < p.length(); j++) {
                sCharCount[ s.charAt(i+j)-'a']+=1;
            }
            if (Arrays.equals(sCharCount,pCharCount)){
                r.add(i);
            }
        }
        return r;

    }
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> r = new ArrayList<>();
        if (s.length() < p.length()) {
            return r;
        }
        if (s.equals(p)){
            return r;
        }
        for (int i = 0; i < s.length(); i++) {

            List<String> list = Arrays.stream(p.split("")).collect(Collectors.toList());
            int interval=0;
            for (int i1 = 0; i1 < p.length(); i1++) {
                int curIndex=i + interval;
                interval+=1;
                if (curIndex>= s.length()){
                    break;
                }
                char c = s.charAt(curIndex);
                list.remove(String.valueOf(c));
            }
            if (list.isEmpty()){
                r.add(i);
            }
        }
        return r;
    }
}
