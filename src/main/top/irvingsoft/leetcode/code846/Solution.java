package top.irvingsoft.leetcode.code846;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 一手顺子
 *
 * @author TimeChaser
 * @since 2021/12/30 1:47 下午
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().isNStraightHand(new int[]{1, 2, 3, 4, 5, 5, 6, 5}, 4));
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : hand) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (int x : hand) {
            if (!map.containsKey(x)) {
                continue;
            }
            for (int y = 0; y < groupSize; y++) {
                int num = x + y;
                if (!map.containsKey(num)) {
                    return false;
                }
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0) {
                    map.remove(num);
                }
            }
        }
        return true;
    }

}
