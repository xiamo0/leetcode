package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/smallest-sufficient-team/description/?envType=problem-list-v2&envId=dynamic-programming
 */
public class SmallestSufficientTeam {

    public static void main(String[] args) {
        String[] req_skills = {};
        List<List<String>> people = new ArrayList<>();
        Arrays.stream(new SmallestSufficientTeam().smallestSufficientTeam(req_skills, peopleo)).forEach(System.out::println);
    }

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {

    }
}
