package binarysearch;

/**
 * https://leetcode.cn/problems/peak-index-in-a-mountain-array/description/?envType=problem-list-v2&envId=binary-search
 * 852. 山脉数组的峰顶索引
 * 中等
 * <p>
 * 相关标签
 * 相关企业
 * 给定一个长度为 n 的整数 山脉 数组 arr ，其中的值递增到一个 峰值元素 然后递减。
 * <p>
 * 返回峰值元素的下标。
 * <p>
 * 你必须设计并实现时间复杂度为 O(log(n)) 的解决方案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [0,1,0]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：arr = [0,2,1,0]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：arr = [0,10,5,2]
 * 输出：1
 */
public class PeakIndexInAMountainArray {

    private int length;

    public int peakIndexInMountainArray1(int[] arr) {

        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < arr[mid + 1]) {
                left = mid;
                continue;
            }
            if (arr[mid] < arr[mid - 1]) {
                right = mid;
                continue;
            }
            return mid;
        }
        return -1;
    }

    public int peakIndexInMountainArray(int[] arr) {
        int length = arr.length;
        int target = length / 2;
        for (; ; ) {
            if (arr[target] < arr[target + 1]) {
                target = (target + length) / 2;
                continue;
            }
            if (arr[target] < arr[target - 1]) {
                target = target / 2;
                continue;
            }
            if (arr[target] > arr[target - 1] && arr[target] > arr[target + 1]) {
                break;
            }
        }
        return target;
    }
}
