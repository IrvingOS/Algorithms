package top.irvingsoft.exam.leetcode.weekly.leetcode268.code2081;

import java.util.ArrayList;
import java.util.List;

/**
 * k 镜像数字的和
 *
 * @author TimeChaser
 * @since 2021/11/21 12:43
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        long num = 1;
        int count = 0;
        for (; num <= 15051; ) {
            count++;
            num = solution.getNextNum(num);
            if (!solution.isMirror(num, 10)) {
                System.out.println("No =========" + num);
            }
        }
        System.out.println("count" + count);
    }

    public long kMirror(int k, int n) {
        int count = 0;
        long num = 1;
        long sum = 0;
        while (count < n) {
            if (isMirror(num, k)) {
                sum += num;
                num = getNextNum(num);
                count++;
            } else {
                num = getNextNum(num);
            }
        }
        return sum;
    }

    private long getNextNum(long num) {
        if (num < 10) {
            return num < 9 ? num + 1 : 11;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(num);
        int n = sb.length();
        if (n % 2 != 0) {
            // 奇数位 101、191、999
            if (sb.charAt(n / 2) < '9') {
                sb.setCharAt(n / 2, (char) (sb.charAt(n / 2) + 1));
                return Long.parseLong(sb.toString());
            } else {
                long leftNum = Long.parseLong(sb.substring(0, n / 2));
                leftNum++;
                StringBuilder newSb = new StringBuilder();
                newSb.append(leftNum);
                if (newSb.length() * 2 > n) {
                    // 999 -> 1001
                    newSb.append(new StringBuilder(newSb).reverse());
                } else {
                    // 191 -> 202
                    newSb.append("0");
                    newSb.append(new StringBuilder(newSb.substring(0, newSb.length() - 1)).reverse());
                }
                return Long.parseLong(newSb.toString());
            }
        } else {
            // 偶数位 1001、1991、9999
            long leftNum = Long.parseLong(sb.substring(0, n / 2));
            leftNum++;
            StringBuilder newSb = new StringBuilder();
            newSb.append(leftNum);
            if (newSb.length() * 2 > n) {
                // 9999 -> 10001
                newSb.append(new StringBuilder(newSb).reverse().substring(1));
            } else {
                // 1991 -> 2002
                newSb.append(new StringBuilder(newSb).reverse());
            }
            return Long.parseLong(newSb.toString());
        }
    }

    private boolean isMirror(long num, int k) {
        List<Long> list = new ArrayList<>();
        while (num != 0) {
            list.add(num % k);
            num /= k;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (!list.get(left++).equals(list.get(right--))) {
                return false;
            }
        }
        return true;
    }

}
