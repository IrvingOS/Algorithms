package top.irvingsoft.foroffer.code10ⅱ;

import java.util.HashMap;
import java.util.Map;

/**
 * 青蛙跳台阶问题
 *
 * @author TimeChaser
 * @since 2021/11/27 15:25
 */
public class Solution {

    private final Map<Integer, Integer> CACHE = new HashMap<>();

    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            if (CACHE.containsKey(n)) {
                return CACHE.get(n);
            }
            int result = (numWays(n - 1) + numWays(n - 2)) % (int) (1e9 + 7);
            CACHE.put(n, result);
            return result;
        }
    }
}
