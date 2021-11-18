package top.irvingsoft.leetcode.code6;

import java.util.ArrayList;

/**
 * Z 字形变换
 *
 * @author TimeChaser
 * @since 2021/10/24 20:55
 */
public class Solution {

    /**
     * 将字符串每个字符赋到二维数组对应的位置上，然后遍历组合新的字符串
     */
    public static String convertChars(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        int length = s.length();
        int numLines = length % (numRows * 2 - 2) == 0 ? (length / (numRows * 2 - 2)) * (numRows - 1) : (length / (numRows * 2 - 2) + 1) * (numRows - 1);
        int cycle = length % (numRows * 2 - 2) == 0 ? length / (numRows * 2 - 2) : length / (numRows * 2 - 2) + 1;
        char[][] chars = new char[numRows][numLines];
        int index = 0;
        for (int i = 0; i < cycle; i++) {
            for (int j = 0; j < numRows && index < s.length(); j++) {
                chars[j][i * (numRows - 1)] = s.charAt(index++);
            }
            int m = numRows - 2;
            int n = i * (numRows - 1) + 1;
            while (m > 0 && n < (i + 1) * (numRows - 1) && index < s.length()) {
                chars[m--][n++] = s.charAt(index++);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char[] aChar : chars) {
            for (char c : aChar) {
                if (Character.isLetter(c) || c == ',' || c == '.') {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    /**
     * 题目不关注每个字符在拆分成的二维数组中的位置，只关注组合后的新字符串
     */
    public static String convertRowSort(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        ArrayList<StringBuilder> rows = new ArrayList<>();
        // 如果字符串的长度小于要求的行数，则直接分配字符串长度个 StringBuilder
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            // 向上遍历触顶或向下遍历触底时转向
            if (curRow == 0 || curRow == rows.size() - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }

    public static String convertRowTraverse(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int length = s.length();
        StringBuilder result = new StringBuilder();
        int cycle = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < length; j += cycle) {
                result.append(s.charAt(i + j));
                if (i != 0 && i != numRows - 1 && j + cycle - i < length) {
                    result.append(s.charAt(j + cycle - i));
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertRowSort("PAYPALISHIRING", 20));
        System.out.println(convertRowSort("PAYPALISHIRING", 4));
        System.out.println(convertRowSort("PAYPALISHIRING", 5));
    }
}
