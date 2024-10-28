import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/implement-trie-prefix-tree/description/?envType=problem-list-v2&envId=2cktkvj
 */
public class ImplementTriePrefixTree_208 {

    class Trie {

        private Queue<String> cache;

        public Trie() {
            cache = new PriorityQueue<>();
        }

        public void insert(String word) {
            cache.add(word);

        }

        public boolean search(String word) {

            return cache.contains(word);
        }

        public boolean startsWith(String prefix) {
            return cache.parallelStream().filter(e -> {
                return e.startsWith(prefix);
            }).findAny().isPresent();
        }
    }

}
