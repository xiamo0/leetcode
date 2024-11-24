import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/description/?envType=problem-list-v2&envId=2cktkvj
 */
public class LeetCode_448 {

    public static void main(String[] args) {
        LeetCode_448 code448 = new LeetCode_448();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(code448.findDisappearedNumbers(nums));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len + 1];
        Arrays.stream(nums).forEach(e -> {
            temp[e] = 1;
        });
        return IntStream.range(1, len + 1).filter(v -> {
            return temp[v] == 0;
        }).boxed().collect(Collectors.toList());
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        int length = nums.length;
        List<Integer> r = new ArrayList<>();
        for (int i = 1; i <= length; i++) {
            r.add(i);
        }
        for (int num : nums) {
            r.remove(Integer.valueOf(num));
        }
        return r;
    }
}
