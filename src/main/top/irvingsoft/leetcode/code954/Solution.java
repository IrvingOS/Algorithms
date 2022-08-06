package top.irvingsoft.leetcode.code954;

import java.util.Map;
import java.util.TreeMap;

/**
 * 二倍数对数组
 *
 * @author TimeChaser
 * @since 2022/4/1 12:49 PM
 */
public class Solution {

    public boolean canReorderDoubled(int[] arr) {
        int n = arr.length;
        if (n % 2 != 0) {
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>((a, b) -> (b - a));
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        while (!map.isEmpty()) {
            Map.Entry<Integer, Integer> first = map.firstEntry();
            if (first.getValue() == 1) {
                map.remove(first.getKey());
            } else {
                first.setValue(first.getValue() - 1);
            }
            if (first.getKey() % 2 != 0 || !map.containsKey(first.getKey() / 2)) {
                return false;
            }
            if (map.get(first.getKey() / 2) == 1) {
                map.remove(first.getKey() / 2);
            } else {
                map.put(first.getKey() / 2, map.get(first.getKey() / 2) - 1);
            }
            System.out.println(map);
        }
        return true;
    }

}
