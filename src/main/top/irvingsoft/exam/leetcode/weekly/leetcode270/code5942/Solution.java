package top.irvingsoft.exam.leetcode.weekly.leetcode270.code5942;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找出 3 位偶数
 *
 * @author TimeChaser
 * @since 2021/12/5 16:00
 */
public class Solution {

    public int[] findEvenNumbers(int[] digits) {
        Arrays.sort(digits);
        List<Integer> list = new ArrayList<>();
        backtrack(0, 0, digits, new boolean[digits.length], list);
        int[] result = new int[list.size()];
        int i = 0;
        while (i < list.size()) {
            result[i] = list.get(i);
            i++;
        }
        return result;
    }

    private void backtrack(int length, int num, int[] digits, boolean[] status, List<Integer> list) {
        if (length == 3) {
            if (num % 2 == 0) {
                list.add(num);
            }
            return;
        }
        for (int i = 0; i < digits.length; i++) {
            if (status[i] || (i > 0 && !status[i - 1] && digits[i] == digits[i - 1]) ||
                (length == 0 && digits[i] == 0)) {
                continue;
            }
            status[i] = true;
            backtrack(length + 1, num * 10 + digits[i], digits, status, list);
            status[i] = false;
        }
    }

}
