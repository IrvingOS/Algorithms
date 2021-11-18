package top.irvingsoft.leetcode.code67;

/**
 * 二进制求和
 *
 * @author TimeChaser
 * @since 2021/11/4 11:07
 */
public class Solution {

    public static String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();

        int n = Math.max(a.length(), b.length());
        int carry = 0;
        for (int i = 0; i < n; i++) {
            carry += i < a.length() ? a.charAt(a.length() - i - 1) - '0' : 0;
            carry += i < b.length() ? b.charAt(b.length() - i - 1) - '0' : 0;
            ans.append(carry % 2);
            carry /= 2;
        }
        if (carry > 0) {
            ans.append(1);
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("101011", "1011"));
    }
}
