import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=problem-list-v2&envId=2cktkvj
 */
public class LongestConsecutiveSequence_128 {

    public static void main(String[] args) {
        LongestConsecutiveSequence_128 sequence128 = new LongestConsecutiveSequence_128();
        // int[] arr = {9,1,4,7,3,-1,0,5,8,-1,6};
        int[] arr = {1, 2, 0, 1};
        System.out.println(sequence128.longestConsecutive(arr));
    }

    public static int[] sortNum(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }

    public int longestConsecutive(int[] nums) {

        List<Integer> collect = Arrays.stream(nums).distinct().sorted().boxed().collect(Collectors.toList());
        int max = 0;
        for (int i = 0; i < collect.size(); i++) {
            int tempMax = 1;
            for (int j = i + 1; j < collect.size(); j++) {
                int cur = collect.get(j);
                int pre =collect.get(j-1);
                if (cur - pre == 1) {
                    tempMax += 1;
                } else if (cur == pre) {
                } else {
                    break;
                }
            }
            if (max < tempMax) {
                max = tempMax;
            }
        }
        return max;

    }
}
