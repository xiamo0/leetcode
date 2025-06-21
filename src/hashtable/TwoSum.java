package hashtable;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remain = target - nums[i];
            if (dictionary.containsKey(remain)) {
                result[0] = i;
                result[1] = dictionary.get(remain);
                return result;
            }
            dictionary.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        new TwoSum().twoSum(nums, 6);
    }
}
