package top.irvingsoft.leetcode.code91;

import java.util.HashMap;
import java.util.Map;

/**
 * 解码方法
 *
 * @author TimeChaser
 * @since 2021/11/6 10:41
 */
public class Solution {

    private static Map<Integer, Integer> cache = new HashMap<>();

    /**
     * 深度优先 + 记忆化搜索
     */
    public static int numDecodingsDFSCache(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        return dfs(s.toCharArray(), 0);
    }

    private static int dfs(char[] arr, int index) {
        if (cache.containsKey(index)) {
            return cache.get(index);
        }
        if (arr.length - index > 0 && arr[index] == '0') {
            return 0;
        }
        if (arr.length - index <= 1) {
            return 1;
        }
        int count = dfs(arr, index + 1);
        if ((arr[index] - '0') * 10 + (arr[index + 1] - '0') <= 26) {
            count += dfs(arr, index + 2);
        }
        cache.put(index, count);
        return count;
    }

    public static int numDecodingsDynamic(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }

    public static int numDecodingsDynamicAnother(String s) {
        int n = s.length();
        int a = 0, b = 1, c = 0;
        for (int i = 1; i <= n; i++) {
            c = 0;
            if (s.charAt(i - 1) != '0') {
                c += b;
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                c += a;
            }
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(numDecodingsDynamic("6211055971756562"));
        System.out.println(numDecodingsDFSCache("111111111111111111111111111111111111111111111"));
        System.out.println(numDecodingsDynamic("1"));
    }
}
