package top.irvingsoft.leetcode.code319;

/**
 * @author TimeChaser
 * @since 2021/10/20 9:37
 */
public class Solution {

    public static int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }

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

    public static void main(String[] args) {
        System.out.println(bulbSwitch(99999999));
    }
}
