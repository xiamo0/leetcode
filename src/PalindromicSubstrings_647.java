/**
 * https://leetcode.cn/problems/palindromic-substrings/description/?envType=problem-list-v2&envId=2cktkvj
 */
public class PalindromicSubstrings_647 {

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }
    public static int countSubstrings(String s) {
        int count = 0;
        int length = s.length();


        for (int endIndex = 0; endIndex <= length; endIndex++) {
            for ( int beginIndex = 0; beginIndex <endIndex ; beginIndex++) {
                boolean b = isPalinsromic(s.substring(beginIndex, endIndex));
                if (b){
                    count++;
                }
            }
            System.out.println("-----");
        }
        return count;


    }

    public  static boolean isPalinsromic(String s) {

        char[] charArray = s.toCharArray();
        for (int i = 0; i <charArray.length/2 ; i++) {
            if (charArray[i]!=charArray[charArray.length-1-i]){
                return false;
            }
        }
        return true;
    }
}
