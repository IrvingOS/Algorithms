package top.irvingsoft.exam.leetcode.weekly.leetcode266.code5919;

import java.util.ArrayList;
import java.util.List;

/**
 * 所有子字符串中的元音
 *
 * @author TimeChaser
 * @since 2021/11/7 10:45
 */
public class Solution {

    private static final List<Character> list = new ArrayList<>();

    static {
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');
    }

    /**
     * 动态规划
     * <p>
     * 超时
     */
    public static long countVowelsDynamic(String word) {
        int n = word.length();
        char[] arr = word.toCharArray();
        boolean[] status = new boolean[n];
        for (int i = 0; i < n; i++) {
            status[i] = list.contains(arr[i]);
        }
        long result = 0;
        for (int i = 0; i < n; i++) {
            long pre = status[i] ? 1 : 0;
            result += pre;
            for (int j = i + 1; j < n; j++) {
                result += status[j] ? ++pre : pre;
            }
        }
        return result;
    }

    public static long countVowelsMath(String word) {
        int n = word.length();
        char[] arr = word.toCharArray();
        long result = 0;
        for (int i = 0; i < n; i++) {
            if (list.contains(arr[i])) {
                result += (long) (i + 1) * (n - i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countVowelsDynamic("noosabas"));
        StringBuilder sb = new StringBuilder("d");
        System.out.println(countVowelsMath(sb.toString()));
    }
}
