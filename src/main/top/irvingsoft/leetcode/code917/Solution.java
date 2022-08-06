package top.irvingsoft.leetcode.code917;

/**
 * 仅仅反转字母
 *
 * @author TimeChaser
 * @since 2022/2/23 11:08
 */
public class Solution {

    public String reverseOnlyLetters(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int lo = 0, hi = n - 1;
        while (true) {
            while (lo < hi && !Character.isLetter(s.charAt(lo))) {
                lo++;
            }
            while (lo < hi && !Character.isLetter(s.charAt(hi))) {
                hi--;
            }
            if (lo >= hi) {
                break;
            }
            swap(arr, lo, hi);
            lo++;
            hi--;
        }
        return new String(arr);
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
