package top.irvingsoft.exam.leetcode.weekly.leetcode268.code5933;

/**
 * k 镜像数字的和
 *
 * @author TimeChaser
 * @since 2021/11/21 12:43
 */
public class Solution {

    private int getNextNum(int num) {
        if (num < 10) {
            return num < 9 ? num + 1 : 11;
        }
        char[] chars = String.valueOf(num).toCharArray();
        int n = chars.length;
        System.out.println(n);
        if (n % 2 != 0) {
            if (chars[n / 2] < '9') {
                chars[n / 2]++;
                return Integer.parseInt(String.valueOf(chars));
            } else {
                int leftNum = 0;
                for (int i = n / 2 - 1; i >= 0; i--) {
                    leftNum = leftNum * 10 + chars[i] - '0';
                }
                leftNum++;
                StringBuilder sb = new StringBuilder();
                sb.append(leftNum);
                sb.append("0");
                sb.append(new StringBuilder(sb.substring(0, sb.length() - 1)).reverse());
                System.out.println(sb);
                return Integer.parseInt(sb.toString());
            }
        } else {
            return 0;
        }
    }

    public long kMirror(int k, int n) {
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getNextNum(101));
        System.out.println(solution.getNextNum(11911));
    }
}
