package top.irvingsoft.leetcode.code38;

/**
 * 外观数列
 *
 * @author TimeChaser
 * @since 2021/11/2 9:58
 */
public class Solution {

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String s = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char ch = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != ch) {
                sb.append(count).append(ch);
                count = 1;
                ch = s.charAt(i);
            } else {
                count++;
            }
        }
        sb.append(count).append(ch);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(6));
    }

}
