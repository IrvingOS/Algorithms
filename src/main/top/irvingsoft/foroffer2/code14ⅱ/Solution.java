package top.irvingsoft.foroffer2.code14ⅱ;

/**
 * 剪绳子 ⅱ
 *
 * @author TimeChaser
 * @since 2021/11/29 11:09
 */
public class Solution {

    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int p = (int) (1e9 + 7);
        int b = n % 3;
        long result = 1;
        int a = n / 3;
        for (int i = 0; i < a - 1; i++) {
            result = result * 3 % p;
        }
        // 快速幂求余
/*        int x = 3;
        for (int a = n / 3 - 1; a > 0; a /= 2) {
            if (a % 2 == 1) {
                result = (result * x) % p;
            }
            x = (x * x) % p;
        }*/
        if (b == 0) {
            return (int) (result * 3 % p);
        } else if (b == 1) {
            return (int) (result * 4 % p);
        } else {
            return (int) (result * 6 % p);
        }
    }
}
