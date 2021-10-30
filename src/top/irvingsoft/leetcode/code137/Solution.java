package top.irvingsoft.leetcode.code137;

import java.util.HashMap;
import java.util.Map;

/**
 * 只出现一次的数字 ⅱ
 *
 * @author TimeChaser
 * @since 2021/10/30 16:30
 */
public class Solution {

    public static int singleNumberHash(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result = entry.getKey();
                break;
            }
        }
        return result;
    }

    public static int singleNumberBinary(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int num : nums) {
                total += (num >> i) & 1;
            }
            if (total % 3 != 0) {
                result |= 1 << i;
            }
        }
        return result;
    }
}
