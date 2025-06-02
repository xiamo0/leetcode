package bitmanipulation;

/*
https://leetcode.cn/problems/convert-a-number-to-hexadecimal/description/?envType=problem-list-v2&envId=bit-manipulation
数字转换为十六进制数
给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。

答案字符串中的所有字母都应该是小写字符，并且除了 0 本身之外，答案中不应该有任何前置零。

注意: 不允许使用任何由库提供的将数字直接转换或格式化为十六进制的方法来解决这个问题。



示例 1：

输入：num = 26
输出："1a"
示例 2：

输入：num = -1
输出："ffffffff"

 */
public class ConvertANumberToHexadecimal {

    public static void main(String[] args) {

//        System.out.println(-1);
//        System.out.println(~1+1);
//        System.out.println(~-1-1);
//        System.out.println(new ConvertANumberToHexadecimal().toHex(-1));
        System.out.println(new ConvertANumberToHexadecimal().toHex1(-1));
    }

    public String toHex(int num) {
        return Integer.toHexString(num);
    }

    public String toHex1(int num) {
        StringBuilder sb = new StringBuilder();
        char[]hexChars="0123456789abcdef".toCharArray();
        System.out.println(Integer.toBinaryString(num));
        while (num!=0){
            int hexDigit=num&0b1111;
            sb.append(hexChars[hexDigit]);
            num>>>=4;
            System.out.println(Integer.toBinaryString(num));

        }
        return sb.reverse().toString();

    }


}
