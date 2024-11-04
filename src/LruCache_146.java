import java.time.LocalDateTime;
import java.util.*;

/**
 * https://leetcode.cn/problems/lru-cache/description/?envType=problem-list-v2&envId=2cktkvj
 */
public class LruCache_146 {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
    }
}

class LRUCache {

    private Integer[] values;
    private int capacity;
    private int curCount = 0;
    private Long[] records;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        values = new Integer[10001];
        records = new Long[10001];

    }

    public int get(int key) {
        Integer value = values[key];
        if (value == null) {
            return -1;
        } else {
            //记录key的操作时间
            addRecords(key);
            return value;
        }

    }

    public void addRecords(int key) {
        records[key] = System.nanoTime();
    }

    public int getOldestKey() {
        long min = System.nanoTime();
        int oldestKey = 0;
        for (int i = 0; i < records.length; i++) {

            if (records[i]!=null && min > records[i]) {
                min = records[i];
                oldestKey = i;
            }
        }
        records[oldestKey] = null;
        return oldestKey;

    }

    public void put(int key, int value) {

        Integer value1 = values[key];
        if (value1 != null) {
            values[key] = value;
            addRecords(key);
        } else {
            if (curCount < capacity) {
                curCount = curCount + 1;
            } else {
                int oldestKey = getOldestKey();
                values[oldestKey] = null;
            }
            values[key] = value;
            addRecords(key);
        }
    }
}

