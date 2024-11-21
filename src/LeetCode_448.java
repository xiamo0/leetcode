import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/description/?envType=problem-list-v2&envId=2cktkvj
 */
public class LeetCode_448 {

    public static void main(String[] args) {

        LeetCode_448 code448 = new LeetCode_448();
        int[] nums={4,3,2,7,8,2,3,1};
        System.out.println(code448.findDisappearedNumbers(nums));
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int length = nums.length;
        List<Integer>r=new ArrayList<>();
        for (int i = 1; i <=length ; i++) {
            r.add(i);
        }
        for (int num : nums) {
           r.remove(Integer.valueOf(num));
        }
        return r;
    }
}
