import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://leetcode.cn/problems/kth-largest-element-in-an-array/description/?envType=problem-list-v2&envId=2cktkvj
 */
public class KthLargestElementInAnArray_215 {

    public int findKthLargest3(int[] nums, int k) {
        //todo

        return -1;


    }
    public int findKthLargest2(int[] nums, int k) {

        Arrays.sort(nums);
        return nums[nums.length - k];

    }
    public int findKthLargest1(int[] nums, int k) {

        if (nums.length<k){
            return -1;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
            if (queue.size()>k){
                queue.poll();
            }
        }
        return queue.peek();



    }
    public int findKthLargest(int[] nums, int k) {

        if (nums.length<k){
            return -1;
        }
        final int[] num = {1};
        AtomicInteger reuslt= new AtomicInteger();

        Arrays.stream(nums).sorted().forEach(e->{
            if (num[0] ==(nums.length-k+1)){
                reuslt.set(e);

            }
            num[0]++;
        });
        return reuslt.get();

    }
}
