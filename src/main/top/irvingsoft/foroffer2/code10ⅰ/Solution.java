package top.irvingsoft.foroffer2.code10ⅰ;

import java.util.HashMap;
import java.util.Map;

/**
 * 斐波拉契数列
 *
 * @author TimeChaser
 * @since 2021/11/27 15:23
 */
public class Solution {

    private final Map<Integer, Integer> CACHE = new HashMap<>();

    public int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            if (CACHE.containsKey(n)) {
                return CACHE.get(n);
            }
            int result = (fib(n - 1) + fib(n - 2)) % (int) (1e9 + 7);
            CACHE.put(n, result);
            return result;
        }
    }
}
