import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Huawei {

    public static void main(String[] args) throws InterruptedException {

        int[] nums = {10, 10, 10, 10, 10};
        System.out.println(maxResult(nums, 5));
        System.out.println(maxResult2(nums, 5));

        int[] nums1 = {1, 10, 3, 3, 3};
        System.out.println(maxResult2(nums1, 3));

    }

    public static long maxResult2(int[] nums, int k) {
        long sum = 0;

        Queue<List<Integer>> queue = new PriorityQueue<>((a, b) -> {
            int i = a.get(0).intValue();
            int j = b.get(0).intValue();
            return j - i;
        });
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            list.add(i);
            queue.add(list);
        }
        while (k > 0) {
            k--;
            List<Integer> peek = queue.poll();
            int tempValue = peek.get(0);
            int tempIndex = peek.get(1);
            sum += tempValue;
            int newValue = tempValue / 3;
            if (newValue * 3 < tempValue) {
                newValue = newValue + 1;
            }
            List<Integer> integers = new ArrayList<>();
            integers.add(newValue);
            integers.add(tempIndex);
            queue.add(integers);
        }
        return sum;
    }

    public static long maxResult(int[] nums, int k) {
        long sum = 0;
        while (k > 0) {
            k--;
            int tempMax = nums[0];
            int tempMaxIndex = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > tempMax) {
                    tempMax = nums[i];
                    tempMaxIndex = i;
                }
            }
            sum += tempMax;
            int temp = tempMax / 3;
            if (temp * 3 < tempMax) {
                temp = temp + 1;
            }
            nums[tempMaxIndex] = temp;
        }
        return sum;
    }
}

/**
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。你的 起始分数 为 0 。
 * 在一步 操作 中：
 * 选出一个满足 0 <= i < nums.length 的下标 i ，
 * 将你的 分数 增加 nums[i] ，并且
 * 将 nums[i] 替换为 ceil(nums[i] / 3) 。
 * 返回在 恰好 执行 k 次操作后，你可能获得的最大分数。
 * <p>
 * 向上取整函数 ceil(val) 的结果是大于或等于 val 的最小整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,10,10,10,10], k = 5
 * 输出：50
 * 解释：对数组中每个元素执行一次操作。最后分数是 10 + 10 + 10 + 10 + 10 = 50 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,10,3,3,3], k = 3
 * 输出：17
 * 解释：可以执行下述操作：
 * 第 1 步操作：选中 i = 1 ，nums 变为 [1,4,3,3,3] 。分数增加 10 。
 * 第 2 步操作：选中 i = 1 ，nums 变为 [1,2,3,3,3] 。分数增加 4 。
 * 第 3 步操作：选中 i = 2 ，nums 变为 [1,1,1,3,3] 。分数增加 3 。
 * 最后分数是 10 + 4 + 3 = 17 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length, k <= 10的5次方
 * 1 <= nums[i] <= 10的9次方
 */