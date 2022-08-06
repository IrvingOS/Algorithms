package top.irvingsoft.leetcode.code869;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 重新排序得到 2 的幂
 *
 * @author TimeChaser
 * @since 2021/10/29 12:31
 */
public class Solution {

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {

        System.out.println(reorderedPowerOf2Hash(64));
    }

    public static boolean permutation(int index, int value, boolean[] status, char[] str) {
        if (index == str.length) {
            return isPowerOfTwo(value);
        }
        for (int i = 0; i < str.length; i++) {
            if (status[i] || (value == 0 && str[i] == '0') || (i > 0 && str[i] == str[i - 1] && status[i - 1])) {
                continue;
            }
            status[i] = true;
            if (permutation(index + 1, value * 10 + str[i] - '0', status, str)) {
                return true;
            }
            status[i] = false;
        }
        return false;
    }

    public static boolean reorderedPowerOf2Hash(int n) {
        HashSet<String> set = new HashSet<>();
        init(set);
        return set.contains(countDigits(n));
    }

    public static boolean reorderedPowerOf2Permutation(int n) {
        char[] str = String.valueOf(n).toCharArray();
        Arrays.sort(str);
        return permutation(0, 0, new boolean[str.length], str);
    }

    private static String countDigits(int n) {
        char[] count = new char[10];
        Arrays.fill(count, '0');
        while (n > 0) {
            count[n % 10]++;
            n /= 10;
        }
        return new String(count);
    }

    private static void init(Set<String> set) {
        for (int i = 1; i <= 1e9; i <<= 1) {
            set.add(countDigits(i));
        }
    }

}
