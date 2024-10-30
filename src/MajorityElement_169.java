import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/majority-element/description/?envType=problem-list-v2&envId=2cktkvj
 */
public class MajorityElement_169 {
    public int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        int lenght=nums.length;
        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num,count) ;
            if (count>lenght/2){
                return num;
            }
        }
        return -1;
    }

}
