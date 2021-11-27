package top.irvingsoft.leetcode.code519;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 随机翻转矩阵
 *
 * @author TimeChaser
 * @since 2021/11/27 10:59
 */
public class Solution {

    private final int                   m;
    private final int                   n;
    private final Map<Integer, Integer> map;
    private final Random                random;
    private       int                   total;

    public Solution(int m, int n) {
        this.m = m;
        this.n = n;
        this.total = m * n;
        this.map = new HashMap<>();
        this.random = new Random();
    }

    public int[] flip() {
        int x = random.nextInt(total--);
        int index = map.getOrDefault(x, x);
        map.put(x, map.getOrDefault(total, total));
        return new int[]{index / n, index % n};
    }

    public void reset() {
        total = m * n;
        map.clear();
    }
}

