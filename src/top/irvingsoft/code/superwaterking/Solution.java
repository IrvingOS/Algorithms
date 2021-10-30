package top.irvingsoft.code.superwaterking;

import java.util.HashMap;
import java.util.Map;

/**
 * 超级水王问题
 * 要求：
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 *
 * @author TimeChaser
 * @since 2021/7/5 12:35
 */
public class Solution {

    /**
     * 使用 Hash 表
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @author TimeChaser
     * @since 2021/7/6 22:54
     */
    public static int verify(int[] arr) {

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

    /**
     * 依次删掉两个不同的数
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * 摩尔投票算法
     * 候选/血量
     * 存在候选时血量不为 0，血量为 0 时不存在候选
     *
     * @author TimeChaser
     * @since 2021/7/6 23:00
     */
    public static int waterKing(int[] arr) {

        if (arr == null || arr.length == 0) {
            return -1;
        }
        int candidate = 0;
        int restHp = 0;
        for (int num : arr) {
            if (restHp == 0) {
                // 如果没有候选，把当前值立为候选
                candidate = num;
                restHp++;
            } else {
                if (candidate != num) {
                    // 当前值不等于候选，两个同时删除，血量减一
                    restHp--;
                } else {
                    // 当前值等于候选，血量值加一
                    restHp++;
                }
            }
        }
        if (restHp == 0) {
            // 遍历完成后，没有候选留下来，即刚好两两不同的删完，说明没有水王数
            return -1;
        }
        // 有候选留下来，判断候选是否是水王数
        int count = 0;
        for (int num : arr) {
            if (num == candidate) {
                count++;
            }
        }
        return count > (arr.length >> 1) ? candidate : -1;
    }
}
