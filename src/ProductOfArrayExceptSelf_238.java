/**
 * https://leetcode.cn/problems/product-of-array-except-self/description/?envType=problem-list-v2&envId=2cktkvj
 */
public class ProductOfArrayExceptSelf_238 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        productExceptSelf(nums);
    }

    public static int[] productExceptSelf(int[] nums) {

        int[] res = new int[nums.length];

        int[] left=new int[nums.length];
        left[0]=1;
        for (int i = 1; i < nums.length; i++) {
            left[i]=left[i-1]*nums[i-1];
        }
        int[] right=new int[nums.length];
        right[nums.length-1]=1;
        for (int i = nums.length-2; i >=0 ; i--) {
            right[i]=right[i+1]*nums[i+1];
        }
        for (int i = 0; i <nums.length ; i++) {
           if (i==0){
               res[i]=right[i];
           }
           if (i==nums.length-1){
               res[i]=left[i];
           }
           res[i]=left[i]*right[i];
        }

        return res;
    }
}
