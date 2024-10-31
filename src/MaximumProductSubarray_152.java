import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/maximum-product-subarray/description/?envType=problem-list-v2&envId=2cktkvj
 */
public class MaximumProductSubarray_152 {

    public static void main(String[] args) {
        System.out.println(4*3/2);
    }
    public int maxProduct1(int[] nums) {

        int row=(nums.length*(nums.length-1));
        int colum=3;
        int[][]dp=new int[row][colum];
        int curRow=0;
        int max=nums[0];
        for (int i = 0; i <nums.length ; i++) {
            for (int j = i; j <nums.length ; j++) {
                dp[curRow][0]=i;
                dp[curRow][1]=j;
                if (i==j){
                    dp[curRow][2]=nums[j];
                }else{
                    dp[curRow][2]=nums[j]*dp[curRow-1][2];
                }
                if (dp[curRow][2]>max){
                    max=dp[curRow][2];
                }
                curRow++;
            }
        }
        return max;

    }
    public int maxProduct(int[] nums) {
        List<List<Integer>>list=new ArrayList<>();
        for (int i = 0; i <nums.length ; i++) {
            for (int j = i; j <nums.length ; j++) {
                List<Integer>temp=new ArrayList<>();
                list.add(temp);
                temp.add(i);
                temp.add(j);
                int multi=1;
                for (int k = i; k <=j ; k++) {
                    multi=multi*nums[k];
                }
                temp.add(multi);
            }
        }
       return list.stream().map(e->{
           return e.get(2);
        }).collect(Collectors.toList()).stream().max(Integer::compareTo).get();

    }
}
