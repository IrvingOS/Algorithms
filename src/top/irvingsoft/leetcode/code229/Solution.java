package top.irvingsoft.leetcode.code229;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author TimeChaser
 * @since 2021/10/22 14:31
 */
public class Solution {

    /**
     * Hash
     *
     * @author TimeChaser
     * @since 2021/10/22 14:45
     */
    public static List<Integer> majorityElementHash(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        int pivot = nums.length / 3;
        for (Integer integer : map.keySet()) {
            if (map.get(integer) > pivot) {
                list.add(integer);
            }
        }
        return list;
    }

    /**
     * 摩尔投票（超级水王问题）
     * <p>
     * 候选人从原问题的 1 个变为 2 个
     *
     * @author TimeChaser
     * @since 2021/10/22 14:45
     */
    public static List<Integer> majorityElementVote(int[] nums) {
        int candidate1 = 0;
        int candidate2 = 0;
        int restHp1 = 0;
        int restHp2 = 0;

        for (int num : nums) {
            if (restHp1 > 0 && candidate1 == num) {
                restHp1++;
            } else if (restHp2 > 0 && candidate2 == num) {
                restHp2++;
            } else if (restHp1 == 0) {
                candidate1 = num;
                restHp1++;
            } else if (restHp2 == 0) {
                candidate2 = num;
                restHp2++;
            } else {
                restHp1--;
                restHp2--;
            }
        }

        int count1 = 0;
        int count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            }
            if (num == candidate2) {
                count2++;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        int boundary = nums.length / 3;
        if (restHp1 > 0 && count1 > boundary) {
            list.add(candidate1);
        }
        if (restHp2 > 0 && count2 > boundary) {
            list.add(candidate2);
        }
        return list;
    }

    public static void main(String[] args) {

        System.out.println(majorityElementVote(new int[]{1, 1, 1, 3, 3, 2, 2, 2}));
    }
}
