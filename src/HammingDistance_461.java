/**
 * https://leetcode.cn/problems/hamming-distance/description/?envType=problem-list-v2&envId=2cktkvj
 */
public class HammingDistance_461 {

    public static void main(String[] args) {
        HammingDistance_461 distance461 = new HammingDistance_461();

        int x = 12;
        int y = 4;
        System.out.println("r = " + distance461.hammingDistance(x, y));
        System.out.println("r = " + distance461.hammingDistance3(x, y));
    }
    public int hammingDistance3(int x, int y) {
        return Integer.bitCount(x ^ y);
    }



    public int hammingDistance(int x, int y) {
        String xBinaryStr = num2BinayStr(x);
        String yBinaryStr = num2BinayStr(y);
        System.out.println(xBinaryStr);
        System.out.println(yBinaryStr);
        int xlength = xBinaryStr.length();
        int ylength = yBinaryStr.length();
        int num = 0;
        while (xlength != ylength) {
            if (xlength > ylength) {
                yBinaryStr = "0" + yBinaryStr;
                ylength += 1;
            } else {
                xBinaryStr = "0" + xBinaryStr;
                xlength += 1;
            }
        }

        for (int i = 0; i < ylength; i++) {
            if (yBinaryStr.charAt(ylength - 1 - i) != xBinaryStr.charAt(xlength - i - 1)) {
                num++;
            }
        }
        return num;

    }

    public String num2BinayStr(int n) {
        String r = "";
        while (n != 0) {
            int temp = n / 2;
            r = (n - temp * 2) + r;
            n = temp;
        }
        return r;

    }
}
