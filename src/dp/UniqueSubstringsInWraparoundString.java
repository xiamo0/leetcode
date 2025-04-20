package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/unique-substrings-in-wraparound-string/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class UniqueSubstringsInWraparoundString {

    public static void main(String[] args) {
        String s = "";
        System.out.println(new UniqueSubstringsInWraparoundString()
                .findSubstringInWraproundString(s));
        System.out.println('z' - 'a');
        System.out.println('b' - 'a');
        System.out.println('y' - 'a');
        System.out.println("abc".substring(0, 1));
    }

    Set<String> subStr = new HashSet<>();
    HashMap<String,Set<String>> contains = new HashMap<>();

    public int findSubstringInWraproundString(String s) {
        if (s.length()==0){
            return 0;
        }
        if (s.length()==1){
            return 1;
        }
        for (int i = 0; i <s.length() ; i++) {
            for (int j = i+1; j <s.length() ; j++) {
                String substring = s.substring(i, j);
            }
        }


        return -1;


    }
}
