package top.irvingsoft.leetcode.code367;

/**
 * 有效的完全平方数
 *
 * @author TimeChaser
 * @since 2021/11/4 8:30
 */
public class Solution {

    public static boolean isPerfectSquareLibrary(int num) {
        int x = (int) Math.sqrt(num);
        return x * x == num;
    }

    public static boolean isPerfectSquareViolence(int num) {
        int x = 1;
        int square = 1;
        while (square <= num) {
            if (square == num) {
                return true;
            }
            x++;
            square = x * x;
        }
        return false;
    }

    public static boolean isPerfectSquareBinary(int num) {
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            long square = (long) mid * mid;
            if (square > num) {
                right = mid - 1;
            } else if (square < num) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(isPerfectSquareBinary(1));
        System.out.println(isPerfectSquareBinary(2));
        System.out.println(isPerfectSquareBinary(4));
        System.out.println(isPerfectSquareBinary(8));
        System.out.println(isPerfectSquareBinary(9));
        System.out.println(isPerfectSquareBinary(14));
        System.out.println(isPerfectSquareBinary(16));
    }
}
