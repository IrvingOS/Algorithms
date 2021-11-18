package top.irvingsoft.exam.leetcode.weekly.leetcode267.code5928;

/**
 * 解码斜向换位密码
 *
 * @author TimeChaser
 * @since 2021/11/14 12:06
 */
public class Solution {

    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        int columns = n / rows;
        char[][] chars = new char[rows][columns];
        for (int i = 0; i < n; i++) {
            chars[i / columns][i % columns] = encodedText.charAt(i);
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (j != columns) {
            int x = i;
            int y = j;
            while (x < rows && y < columns) {
                sb.append(chars[x++][y++]);
            }
            j++;
        }
        return sb.substring(0, sb.indexOf(sb.toString().trim())) + sb.toString().trim();
    }
}
