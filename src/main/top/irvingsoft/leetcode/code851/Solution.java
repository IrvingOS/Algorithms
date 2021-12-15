package top.irvingsoft.leetcode.code851;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 喧闹或富有
 * <p>
 * TODO 使用 图 来求解该题
 *
 * @author TimeChaser
 * @since 2021/12/15 10:56
 */
public class Solution {

    private final Map<Integer, Integer> cache = new HashMap<>();

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] rich : richer) {
            map.computeIfAbsent(rich[1], v -> new ArrayList<>()).add(rich[0]);
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = getQuietest(i, map, quiet);
        }
        return result;
    }

    private int getQuietest(int i, Map<Integer, List<Integer>> map, int[] quiet) {
        if (cache.containsKey(i)) {
            return cache.get(i);
        }
        int min = i;
        List<Integer> persons = map.get(i);
        if (persons != null && persons.size() != 0) {
            for (Integer person : persons) {
                int ret = getQuietest(person, map, quiet);
                min = quiet[ret] < quiet[min] ? ret : min;
            }
        }
        cache.put(i, min);
        return min;
    }
}
