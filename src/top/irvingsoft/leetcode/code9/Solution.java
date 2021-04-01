package top.irvingsoft.leetcode.code9;

/**
 * @description: 回文数
 * @author: TimeChaser
 * @date: 2021/4/1 11:49
 */
public class Solution {

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }

        return rev == x || x == rev / 10;
    }

    public static void main(String[] args) {

        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(-101));
    }
}
