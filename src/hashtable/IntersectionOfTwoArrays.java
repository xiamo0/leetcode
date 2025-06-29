package hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/*
https://leetcode.cn/problems/intersection-of-two-arrays/description/?envType=problem-list-v2&envId=hash-table
两个数组的交集

给定两个数组 nums1 和 nums2 ，返回 它们的 交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。



示例 1：

输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]
示例 2：

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]
解释：[4,9] 也是可通过的
 */
public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays();
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] result = intersectionOfTwoArrays.intersection(nums1, nums2);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public int[] intersection(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums1).distinct().forEach(i -> map.put(i, map.getOrDefault(i, 0) + 1));
        Arrays.stream(nums2).distinct().forEach(i -> map.put(i, map.getOrDefault(i, 0) - 1));

        return map.keySet().stream().filter(k -> {
            return map.get(k) == 0;
        }).mapToInt(Integer::intValue).distinct().toArray();
    }

}
