import java.util.HashSet;

/***
 * https://leetcode.cn/problems/single-number/?envType=problem-list-v2&envId=2cktkvj
 */
public class SingleNumber_136 {

    public int singleNumber2(int[] nums) {
        int r = nums[0];
        for (int i = 1; i < nums.length; i++) {
            r ^= nums[i];
        }
        return r;
    }

    public int singleNumber1(int[] nums) {
        HashSet<Integer> objects = HashSet.newHashSet(16);

        for (int num : nums) {
            if (objects.contains(nums)) {
                objects.remove(num);
            } else {
                objects.add(num);
            }
        }
        return (int) objects.toArray()[0];
    }

    public int singleNumber(int[] nums) {

        int[] positiveNumberCount = new int[3 * 10000];
        int[] negativeNumberCount = new int[3 * 10000];

        for (int num : nums) {
            if (num >= 0) {
                positiveNumberCount[num] = positiveNumberCount[num] + 1;
            } else {
                negativeNumberCount[Math.abs(num)] = negativeNumberCount[Math.abs(num)] + 1;
            }
        }
        for (int i = 0; i < positiveNumberCount.length; i++) {
            if (positiveNumberCount[i] == 2) {
                return i;
            }
        }
        for (int i = 0; i < negativeNumberCount.length; i++) {
            if (negativeNumberCount[i] == 2) {
                return 0 - i;
            }
        }
        return 0;


    }
}
