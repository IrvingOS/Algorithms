package top.irvingsoft.exam.leetcode.weekly.leetcode273.code5964;

/**
 * 执行所有后缀指令
 *
 * @author TimeChaser
 * @since 2021/12/26 13:31
 */
public class Solution {

    public int[] executeInstructions(int n, int[] startPos, String s) {
        int size = s.length();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            int[] curPos = new int[2];
            curPos[0] = startPos[0];
            curPos[1] = startPos[1];
            int j = i;
            for (; j < size; j++) {
                switch (s.charAt(j)) {
                    case 'L':
                        curPos[1]--;
                        break;
                    case 'R':
                        curPos[1]++;
                        break;
                    case 'U':
                        curPos[0]--;
                        break;
                    case 'D':
                        curPos[0]++;
                        break;
                    default:
                        break;
                }
                if (curPos[0] < 0 || curPos[1] < 0 || curPos[0] >= n || curPos[1] >= n) {
                    break;
                }
            }
            result[i] = j - i;
        }
        return result;
    }

}
