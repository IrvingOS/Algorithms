package top.irvingsoft.leetcode.code397;

import java.util.HashMap;
import java.util.Map;

/**
 * 整数替换
 *
 * @author TimeChaser
 * @since 2021/11/19 10:01
 */
public class Solution {

    private final Map<Integer, Integer> cache = new HashMap<>();

    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        if (!cache.containsKey(n)) {
            if (n % 2 == 0) {
                cache.put(n, integerReplacement(n >> 1) + 1);
            } else {
                cache.put(n, Math.min(integerReplacement(n >> 1), integerReplacement(n >> 1 + 1)) + 2);
            }
        }
        return cache.get(n);
    }

    public int integerReplacementGreed(int n) {
        int result = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                result++;
                n >>= 1;
            } else {
                if (n % 4 == 1) {
                    n >>= 1;
                } else {
                    if (n == 3) {
                        n = 1;
                    } else {
                        n = (n >> 1) + 1;
                    }
                }
                result += 2;
            }
        }
        return result;
    }
}
