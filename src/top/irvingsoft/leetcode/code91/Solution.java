package top.irvingsoft.leetcode.code91;

/**
 * 解码方法
 *
 * @author TimeChaser
 * @since 2021/11/6 10:41
 */
public class Solution {

    /**
     * 深度优先
     * <p>
     * 超时
     */
    public static int numDecodingsDFS(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        char[] arr = s.toCharArray();
        return dfs(arr, 0, 0);
    }

    private static int dfs(char[] arr, int index, int count) {
        if (index == arr.length) {
            return ++count;
        }
        if (arr[index] == '0') {
            return count;
        }
        int num = 0;
        for (int i = index; i < arr.length; i++) {
            num = num * 10 + arr[i] - '0';
            if (num <= 26) {
                count = dfs(arr, i + 1, count);
            } else {
                break;
            }
        }
        return count;
    }

    public static int numDecodingsDynamic(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
        System.out.println(numDecodingsDFS("6211055971756562"));
        System.out.println(numDecodingsDynamic("111111111111111111111111111111111111111111111"));
        System.out.println(numDecodingsDynamic("0"));
    }
}
