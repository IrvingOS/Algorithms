package top.irvingsoft.leetcode.code423;

import java.util.HashMap;
import java.util.Map;

/**
 * 从英文中重建数字
 *
 * @author TimeChaser
 * @since 2021/11/24 20:56
 */
public class Solution {

    public String originalDigits(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int[] count = new int[10];
        count[0] = map.getOrDefault('z', 0);
        count[2] = map.getOrDefault('w', 0);
        count[6] = map.getOrDefault('x', 0);
        count[8] = map.getOrDefault('g', 0);
        count[3] = map.getOrDefault('h', 0) - count[8];
        count[7] = map.getOrDefault('s', 0) - count[6];
        count[5] = map.getOrDefault('v', 0) - count[7];
        count[4] = map.getOrDefault('f', 0) - count[5];
        count[9] = map.getOrDefault('i', 0) - count[5] - count[6] - count[8];
        count[1] = map.getOrDefault('o', 0) - count[4] - count[2] - count[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < count[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}
