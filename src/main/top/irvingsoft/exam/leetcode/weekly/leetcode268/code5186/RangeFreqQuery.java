package top.irvingsoft.exam.leetcode.weekly.leetcode268.code5186;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 区间内查询数字的最大频率
 *
 * @author TimeChaser
 * @since 2021/11/21 12:10
 */
public class RangeFreqQuery {

    private final Map<Integer, TreeMap<Integer, Integer>> map;
    private final Map<Integer, Integer> initialMap;

    public RangeFreqQuery(int[] arr) {
        this.map = new HashMap<>();
        this.initialMap = new TreeMap<>();
        this.initialMap.put(-1, 0);
        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], t -> new TreeMap<>(this.initialMap)).put(i, map.get(arr[i]).size());
        }
//        System.out.println(map);
    }

    public int query(int left, int right, int value) {
        return map.computeIfAbsent(value, t -> new TreeMap<>(this.initialMap)).floorEntry(right).getValue()
                - map.get(value).lowerEntry(left).getValue();
    }
}