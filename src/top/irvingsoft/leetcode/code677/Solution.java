package top.irvingsoft.leetcode.code677;

import java.util.HashMap;
import java.util.Map;

/**
 * 键值映射
 *
 * @author TimeChaser
 * @since 2021/11/14 8:51
 */
public class Solution {

}

class MapSum {

    private final Map<String, Integer> map;

    public MapSum() {
        this.map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int sum = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getKey().startsWith(prefix)) {
                sum += entry.getValue();
            }
        }
        return sum;
    }
}