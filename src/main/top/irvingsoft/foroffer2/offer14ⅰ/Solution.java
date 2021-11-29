package top.irvingsoft.foroffer2.offer14ⅰ;

/**
 * 剪绳子 ⅰ
 *
 * @author TimeChaser
 * @since 2021/11/29 10:41
 */
public class Solution {

    /**
     * 贪心
     */
    public int cuttingRope(int n) {
        if (n < 4) {
            return n - 1;
        }
        int[] products = new int[n + 1];
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = i - 1; j >= i / 2; j--) {
                max = Math.max(max, products[j] * products[i - j]);
            }
            products[i] = max;
        }
        return products[n];
    }

    /**
     * 数学推导
     */
    public int cuttingRopeMath(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3, b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, a);
        }
        if (b == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        }
        return (int) Math.pow(3, a) * 2;
    }
}
