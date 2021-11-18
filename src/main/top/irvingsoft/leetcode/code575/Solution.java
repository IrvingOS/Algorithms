package top.irvingsoft.leetcode.code575;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 分糖果
 *
 * @author TimeChaser
 * @since 2021/11/1 13:04
 */
public class Solution {

    public static int distributeCandies(int[] candyType) {
        int count = candyType.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int candy : candyType) {
            map.put(candy, map.getOrDefault(candy, 0) + 1);
        }
        int singleCount = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                singleCount++;
            }
        }
        if (singleCount >= count) {
            return count;
        } else {
            int multiCount = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() != 1) {
                    multiCount++;
                }
            }
            return Math.min(singleCount + multiCount, count);
        }
    }

    public static int distributeCandiesAnother(int[] candyType) {
        HashSet<Integer> set = new HashSet<>();
        for (int candy : candyType) {
            set.add(candy);
        }
        return Math.min(set.size(), candyType.length / 2);
    }

    public static void main(String[] args) {
        System.out.println(distributeCandies(new int[]{1, 1, 2, 2, 3, 3}));
        System.out.println(distributeCandies(new int[]{1, 1, 2, 3}));
        System.out.println(distributeCandies(new int[]{1, 1}));
        System.out.println(distributeCandiesAnother(new int[]{0, 0, 14, 0, 10, 0, 0, 0}));
    }
}
