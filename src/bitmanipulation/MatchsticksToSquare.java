package bitmanipulation;

import java.util.Arrays;
import java.util.HashSet;

/*
https://leetcode.cn/problems/matchsticks-to-square/description/?envType=problem-list-v2&envId=bit-manipulation

火柴拼正方形
你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。你要用 所有的火柴棍 拼成一个正方形。你 不能折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。

如果你能使这个正方形，则返回 true ，否则返回 false 。

输入: matchsticks = [1,1,2,2,2]
输出: true
解释: 能拼成一个边长为2的正方形，每边两根火柴。
示例 2:

输入: matchsticks = [3,3,3,3,4]
输出: false
解释: 不能用所有火柴拼成一个正方形。


提示:

1 <= matchsticks.length <= 15
1 <= matchsticks[i] <= 108

 */
public class MatchsticksToSquare {
    public static void main(String[] args) {
        int[] num = {10, 6, 5, 5, 5, 3, 3, 3, 2, 2, 2, 2};
        System.out.println(new MatchsticksToSquare().makesquare(num));
    }

    public boolean makesquare(int[] matchsticks) {

        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) {
            return false;
        }
        int edge = sum / 4;
        Arrays.sort(matchsticks);

        if (matchsticks.length < 4) {
            return false;
        }
        if (matchsticks.length == 4) {
            return matchsticks[0] == edge && matchsticks[3] == edge;
        }
        if (edge < matchsticks[matchsticks.length - 1]) {
            return false;
        }
        int[] edges = new int[4];
        HashSet<Integer> cache = new HashSet<>();
        for (int i = 0; i < edges.length; i++) {
            for (int i1 = 0; i1 < matchsticks.length; i1++) {
                if (cache.contains(i1)) {
                    continue;
                }
                int i2 = edges[i] + matchsticks[i1];
                int remain = edge - i2;
                if (remain < 0) {
                    continue;
                }
                if (remain == 0) {
                    cache.add(i1);
                    edges[i] = edge;
                    continue;
                }
                if (remain > 0) {
                    //寻找
                    cache.add(i1);
                    edges[i] = remain;
                }
            }
            if (edges[i] != edge) {
                return false;
            }

        }
        return true;
    }

    public boolean makesquare1(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) return false;
        int edge = sum / 4;
        Arrays.sort(matchsticks); // 降序排序
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int tmp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = tmp;
        }
        int[] edges = new int[4]; // 四条边的长度
        return dfs(matchsticks, 0, edges, edge);
    }

    private boolean dfs(int[] matchsticks, int index, int[] edges, int edge) {
        if (index == matchsticks.length) {
            return edges[0] == edge && edges[1] == edge && edges[2] == edge && edges[3] == edge;
        }
        for (int i = 0; i < 4; i++) {
            if (edges[i] + matchsticks[index] > edge) continue; // 剪枝
            edges[i] += matchsticks[index];
            if (dfs(matchsticks, index + 1, edges, edge)) return true;
            edges[i] -= matchsticks[index]; // 回溯
            // 剪枝：如果放到当前边无法成功，且该边为空，则其他边也不会成功
            if (edges[i] == 0) break;
        }
        return false;
    }

}
