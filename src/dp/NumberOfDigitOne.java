package dp;

/**
 * https://leetcode.cn/problems/number-of-digit-one/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class NumberOfDigitOne {
    //1  10 11 12 13
    public static void main(String[] args) {
        NumberOfDigitOne numberOfDigitOne = new NumberOfDigitOne();
        System.out.println(numberOfDigitOne.countDigitOne(13));

    }


    char[] charArray = null;
    int count = 0;
    public int countDigitOne(int n) {
        charArray = String.valueOf(n).toCharArray();

        return 0;

    }
    void dfs(int pos){
        if (pos == charArray.length){
            return;
        }
        int i = charArray[pos] - '0';
        for (int j = 0; j < i; j++) {

        }

    }

    public int countDigitOne1(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            String s = "" + i;
            for (char c : s.toCharArray()) {
                if (c == '1') {
                    result++;
                }
            }
        }
        return result;
    }


}
