import java.util.*;

/**
 * https://leetcode.cn/problems/course-schedule/description/?envType=problem-list-v2&envId=2cktkvj
 */
public class CourseSchedule_207 {


    /**
     * 用map 缓存一个关于 学习该门学科之前 必须应学习的其他学科，学科a->[学科b,学科c,...]
     * 当该门 学科 没有需要学习的其他学科时，则可以学习该门学科（设置对应），学习完该门学科后，就删除其他学科 的待学队列中的该门学科
     * 直到所有学科 对应的待学队列
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int[] cur = prerequisites[i];
            int then = cur[0];
            int first = cur[1];
            List<Integer> list = map.get(then);
            list.add(first);
        }
        for (; ; ) {

            for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
                Integer key = entry.getKey();
                List<Integer> value = entry.getValue();
                if (value != null && value.isEmpty()) {
                    entry.setValue(null);
                    for (Map.Entry<Integer, List<Integer>> entry1 : map.entrySet()) {
                        List<Integer> value1 = entry1.getValue();
                        if (value1 != null) {
                            value1.remove(key);
                        }
                    }
                }
            }

            boolean b = map.values().stream().anyMatch(e -> {
                return (e != null) && e.isEmpty();
            });
            if (!b) {
                break;
            }
        }
        for (List<Integer> value : map.values()) {
            if (value != null && !value.isEmpty()) {
                return false;
            }
        }
        return true;

    }

}
