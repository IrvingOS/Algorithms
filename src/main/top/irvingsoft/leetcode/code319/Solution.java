package top.irvingsoft.leetcode.code319;

/**
 * 灯泡开关
 *
 * @author TimeChaser
 * @since 2021/10/20 9:37
 */
public class Solution {

    public static int bulbSwitch(int n) {
        return (int) Math.sqrt(n + 0.5);
    }

    /**
     * 模拟超时
     */
    public static int bulbSwitchArray(int n) {

        boolean[] booleans = new boolean[n];
        int index = 0;
        for (int i = 1; i <= n; i++, index = i - 1) {
            while (index < n) {
                booleans[index] = !booleans[index];
                index += i;
            }
        }
        int count = 0;
        for (boolean aBoolean : booleans) {
            if (aBoolean) {
                ++count;
            }
        }
        return count;
    }

    /**
     * 找规律
     */
    public static int bulbSwitchMath(int n) {
        if (n == 0) {
            return 0;
        }
        int num = 0;
        int count = 0;
        int increase = 2;
        while (num < n) {
            num++;
            num += increase;
            increase += 2;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(bulbSwitch(99999999));
    }

}
