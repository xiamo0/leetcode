import java.util.*;

/**
 * https://leetcode.cn/problems/min-stack/description/?envType=problem-list-v2&envId=2cktkvj
 */
public class MinStack_155 {


    public static void main(String[] args) {


        MinStack1 minStack = new MinStack1();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println(minStack.getMin());
        minStack.pop();

        System.out.println(minStack.top());

        System.out.println(minStack.getMin());

    }
    static class MinStack1 {

        private Deque<Integer> cache = new ArrayDeque<>();

        private Queue<Integer> min = new PriorityQueue<>();
        public MinStack1() {

        }

        public void push(int val) {
            cache.push(val);
            if (!min.contains(val)){
                min.add(val);
            }

        }

        public void pop() {
            Integer pop = cache.pop();
            min.remove(pop);
        }

        public int top() {
            return cache.getLast();
        }

        public int getMin() {
            if (!min.isEmpty()){
                Integer poll = min.poll();
                min.add(poll);
                return poll;
            }
            return 0;
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */

    class MinStack {

        private Integer[] cache = new Integer[1000];
        private int beginIndex = 0;
        private int endIndex = -1;
        private Integer min = null;

        public MinStack() {

        }

        public void push(int val) {
            endIndex++;
            cache[endIndex] = val;


        }

        public void pop() {
            if (endIndex > -1) {
                cache[endIndex--] = null;
            }
        }

        public int top() {
            return cache[endIndex];
        }

        public int getMin() {

            int min = cache[0];
            for (int i = 1; i < cache.length; i++) {
                if (cache[i] != null && min > cache[i]) {
                    min = cache[i];
                }
            }

            return min;

        }

    }
}
