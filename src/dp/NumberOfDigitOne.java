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

    public int countDigitOne(int n) {

        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (("" + i).contains("1")) {
                result++;
            }
        }
        return result;
    }

    static
}
