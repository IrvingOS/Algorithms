package top.irvingsoft.exam.leetcode.weekly.leetcode276.code2138;

/**
 * 将字符串拆分长若干长度为 k 的组
 *
 * @author TimeChaser
 * @since 2022/1/17 3:17 下午
 */
public class Solution {

    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int size = n % k != 0 ? n / k + 1 : n / k;
        String[] result = new String[size];
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < size) {
            int j = 0;
            while (j < k) {
                if (i * k + j < n) {
                    sb.append(s.charAt(i * k + j));
                } else {
                    sb.append(fill);
                }
                j++;
            }
            result[i] = sb.toString();
            sb = new StringBuilder();
            i++;
        }
        return result;
    }

}
