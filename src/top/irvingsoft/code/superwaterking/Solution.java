package top.irvingsoft.code.superwaterking;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 超级水王问题
 * @author: TimeChaser
 * @date: 2021/7/5 12:35
 */
public class Solution {

    private static int verify(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        HashMap<Integer, Integer> map = new HashMap<>(8);
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        int n = arr.length;
        for (Map.Entry<Integer, Integer> record : map.entrySet()) {
            if (record.getValue() > (n >> 1)) {
                return record.getKey();
            }
        }
        return -1;
    }
}
