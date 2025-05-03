package dp;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.cn/problems/smallest-sufficient-team/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class SmallestSufficientTeam {

    public static void main(String[] args) {
        Set<Integer> collect = IntStream.range(0, 3).boxed().collect(Collectors.toSet());

        String[] req_skills = {};
        List<List<String>> people = new ArrayList<>();
        Arrays.stream(new SmallestSufficientTeam().smallestSufficientTeam(req_skills, people)).forEach(System.out::println);
    }

    public static int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length;
        int skillBits = 0;

        // 技能 → 二进制位
        Map<String, Integer> skillMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            skillMap.put(req_skills[i], i);
        }

        // 将每个人的技能转化为 bitmask
        int[] peopleSkills = new int[people.size()];
        for (int i = 0; i < people.size(); i++) {
            List<String> skills = people.get(i);
            int mask = 0;
            for (String skill : skills) {
                if (skillMap.containsKey(skill)) {
                    mask |= 1 << skillMap.get(skill);
                }
            }
            peopleSkills[i] = mask;
        }

        // dp[state] 表示达到该技能状态所需要的最少人数集合（用 bitset 表示）
        Map<Integer, Set<Integer>> dp = new HashMap<>();
        dp.put(0, new HashSet<>());

        for (int i = 0; i < people.size(); i++) {
            int personSkill = peopleSkills[i];
            if (personSkill == 0) continue; // 这个人没有有用技能

            // 遍历当前所有的技能状态
            List<Integer> states = new ArrayList<>(dp.keySet());
            for (int prevSkill : states) {
                int newSkill = prevSkill | personSkill;
                if (!dp.containsKey(newSkill) || dp.get(prevSkill).size() + 1 < dp.get(newSkill).size()) {
                    Set<Integer> newSet = new HashSet<>(dp.get(prevSkill));
                    newSet.add(i);
                    dp.put(newSkill, newSet);
                }
            }
        }

        // 最终目标是所有技能都满足：即 (1 << n) - 1
        int target = (1 << n) - 1;
        Set<Integer> result = dp.get(target);

        // 转换为数组返回
        int[] ans = new int[result.size()];
        int idx = 0;
        for (int x : result) ans[idx++] = x;
        return ans;
    }

    public int[] smallestSufficientTeam1(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length, m = people.size();
        HashMap<String, Integer> skill_index = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            skill_index.put(req_skills[i], i);
        }
        List<Integer>[] dp = new List[1 << n];
        dp[0] = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            int cur_skill = 0;
            for (String s : people.get(i)) {
                cur_skill |= 1 << skill_index.get(s);
            }
            for (int prev = 0; prev < dp.length; ++prev) {
                if (dp[prev] == null) {
                    continue;
                }
                int comb = prev | cur_skill;
                if (dp[comb] == null || dp[prev].size() + 1 < dp[comb].size()) {
                    dp[comb] = new ArrayList<>(dp[prev]);
                    dp[comb].add(i);
                }
            }
        }
        return dp[(1 << n) - 1].stream().mapToInt(i -> i).toArray();
    }


}
