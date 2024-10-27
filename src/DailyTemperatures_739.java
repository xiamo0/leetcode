import java.util.Stack;

/**
 * https://leetcode.cn/problems/daily-temperatures/description/?envType=problem-list-v2&envId=2cktkvj
 */
public class DailyTemperatures_739 {


    public static void main(String[] args) {
        int[] answer = new int[10];
        System.out.println(answer[1]);
    }

    public static int[] dailyTemperatures2(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {

            int curTemp = temperatures[i];
            while (!stack.isEmpty() && temperatures[stack.peek()] <curTemp ){
               answer[stack.peek()] = i - stack.peek();
               stack.pop();
            }
            stack.push(i);

        }
        return answer;
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            answer[i] = tap(i, temperatures);
        }
        return answer;
    }

    public static int tap(int index, int[] temperatures) {
        int cur = temperatures[index];
        for (int i = index + 1; i < temperatures.length; i++) {
            if (temperatures[i] > cur) {
                return i - index;
            }
        }
        return 0;

    }
}
