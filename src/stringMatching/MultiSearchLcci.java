package stringMatching;

import java.util.ArrayList;
import java.util.List;


/**
 * https://leetcode.cn/problems/multi-search-lcci/description/?envType=problem-list-v2&envId=string-matching
 * <p>
 * 多次搜索
 * 给定一个较长字符串big和一个包含较短字符串的数组smalls，设计一个方法，根据smalls中的每一个较短字符串，对big进行搜索。输出smalls中的字符串在big里出现的所有位置positions，其中positions[i]为smalls[i]出现的所有位置。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * big = "mississippi"
 * smalls = ["is","ppi","hi","sis","i","ssippi"]
 * 输出： [[1,4],[8],[],[3],[1,4,7,10],[5]]
 * 提示：
 * <p>
 * 0 <= len(big) <= 1000
 * 0 <= len(smalls[i]) <= 1000
 * smalls的总字符数不会超过 106。
 * 你可以认为smalls中没有重复字符串。
 */
public class MultiSearchLcci {

    public static void main(String[] args) {
//        String big="mississippi";
//        String[]smalls={"is","ppi","hi","sis","i","ssippi"};


        String big = "abc";
        String[] smalls = {""};

        System.out.println(multiSearch(big, smalls));
    }

    public static int[][] multiSearch(String big, String[] smalls) {

        List<List<Integer>> indexList = new ArrayList<>(smalls.length);
        for (int i = 0; i < smalls.length; i++) {
            List<Integer> temp = new ArrayList<>();
            int index = 0;
            indexList.add(i, temp);
            if ("".equals(smalls[i])) {
                break;
            }

            while ((index = big.indexOf(smalls[i], index)) >= 0) {
                temp.add(index);
                index += 1;
            }
        }
        int[][] r = new int[smalls.length][];
        for (int i = 0; i < indexList.size(); i++) {
            List<Integer> list = indexList.get(i);

            r[i] = new int[list.size()];

            for (int i1 = 0; i1 < list.size(); i1++) {
                r[i][i1] = list.get(i1);
            }
        }

        return r;

    }

}
