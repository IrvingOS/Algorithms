package top.irvingsoft.leetcode.code171;

/**
 * Excel 表列序号
 *
 * @author TimeChaser
 * @since 2021/11/6 11:41
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(titleToNumber("A"));
        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("ZY"));
    }

    public static int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            result = result * 26 + columnTitle.charAt(i) - 'A' + 1;
        }
        return result;
    }

}
