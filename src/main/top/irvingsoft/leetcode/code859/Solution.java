package top.irvingsoft.leetcode.code859;

/**
 * 亲密字符串
 *
 * @author TimeChaser
 * @since 2021/11/23 9:10
 */
public class Solution {

    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        if (s.equals(goal)) {
            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                count[index]++;
                if (count[index] > 1) {
                    return true;
                }
            }
            return false;
        } else {
            int first = -1;
            int second = -1;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != goal.charAt(i)) {
                    if (first == -1) {
                        first = i;
                    } else if (second == -1) {
                        second = i;
                    } else {
                        break;
                    }
                }
            }
            for (int i = 0; i < s.length(); i++) {
                if (i == first || i == second) {
                    continue;
                }
                if (s.charAt(i) != goal.charAt(i)) {
                    return false;
                }
            }
            return second != -1 && s.charAt(first) == goal.charAt(second) && s.charAt(second) == goal.charAt(first);
        }
    }

}
