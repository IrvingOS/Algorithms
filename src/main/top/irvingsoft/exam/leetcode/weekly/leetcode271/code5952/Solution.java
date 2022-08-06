package top.irvingsoft.exam.leetcode.weekly.leetcode271.code5952;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 环和杆
 *
 * @author TimeChaser
 * @since 2021/12/12 12:18
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().countPoints("B0B6G0R6R0R6G9"));
    }

    public int countPoints(String rings) {
        int n = rings.length();
        Map<Integer, Set<Character>> map = new HashMap<>(n / 2);
        for (int i = 0; i < n - 1; i += 2) {
            map.computeIfAbsent(rings.charAt(i + 1) - '0', v -> new HashSet<>()).add(rings.charAt(i));
        }
        int count = 0;
        for (Map.Entry<Integer, Set<Character>> entry : map.entrySet()) {
            if (entry.getValue().size() == 3) {
                count++;
            }
        }
        return count;
    }

}
