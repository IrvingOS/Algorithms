package top.irvingsoft.foroffer2.code60;

import java.util.Arrays;

/**
 * n 个骰子的点数
 *
 * @author TimeChaser
 * @since 2021/12/11 13:12
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().dicesProbability(3)));
    }

    public double[] dicesProbability(int n) {
        double[] probability = new double[6];
        Arrays.fill(probability, 1.0 / 6);
        for (int i = 2; i <= n; i++) {
            double[] temp = new double[i * 5 + 1];
            for (int j = 0; j < probability.length; j++) {
                for (int k = 0; k < 6; k++) {
                    temp[j + k] += probability[j] / 6.0;
                }
            }
            probability = temp;
        }
        return probability;
    }
}
