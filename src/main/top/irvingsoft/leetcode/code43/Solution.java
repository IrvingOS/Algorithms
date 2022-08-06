package top.irvingsoft.leetcode.code43;

/**
 * 字符串相乘
 *
 * @author TimeChaser
 * @since 2021/11/2 10:19
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(multiply("103", "98"));
        System.out.println(multiply("98", "103"));
    }

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        StringBuilder result = new StringBuilder("0");
        for (int i = num1.length() - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                count += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                sb.append(count >= 10 ? count % 10 : count);
                count = count >= 10 ? count / 10 : 0;
            }
            if (count != 0) {
                sb.append(count);
            }
            for (int j = i + 1; j < num1.length(); j++) {
                sb.insert(0, 0);
            }
            result = addUp(result, sb.reverse());
        }
        return result.toString();
    }

    public static String multiplyFaster(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        int[] ansArr = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                ansArr[i + j + 1] += x * y;
            }
        }
        for (int i = m + n - 1; i > 0; i--) {
            ansArr[i - 1] += ansArr[i] / 10;
            ansArr[i] = ansArr[i % 10];
        }
        int index = ansArr[0] == 0 ? 1 : 0;
        StringBuilder ans = new StringBuilder();
        while (index < m + n) {
            ans.append(ansArr[index++]);
        }
        return ans.toString();
    }

    private static StringBuilder addUp(StringBuilder a, StringBuilder b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int count = 0;
        while (i >= 0 && j >= 0) {
            count += a.charAt(i) - '0' + b.charAt(j) - '0';
            result.append(count >= 10 ? count % 10 : count);
            count = count >= 10 ? count / 10 : 0;
            i--;
            j--;
        }
        if (i < 0 && j < 0 && count != 0) {
            result.append(count);
            return result.reverse();
        }
        while (i >= 0) {
            count += a.charAt(i) - '0';
            result.append(count >= 10 ? count % 10 : count);
            count = count >= 10 ? count / 10 : 0;
            i--;
        }
        while (j >= 0) {
            count += b.charAt(j) - '0';
            result.append(count >= 10 ? count % 10 : count);
            count = count >= 10 ? count / 10 : 0;
            j--;
        }
        if (count != 0) {
            result.append(count);
        }
        return result.reverse();
    }

}
