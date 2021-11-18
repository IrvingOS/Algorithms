package top.irvingsoft.leetcode.code492;

import java.util.Arrays;

/**
 * @author TimeChaser
 * @since 2021/10/23 13:59
 */
public class Solution {

    public static int[] constructRectangle(int area) {
        int sqrt = (int) Math.sqrt(area);
        while (area % sqrt != 0) {
            sqrt--;
        }
        return new int[]{area / sqrt, sqrt};
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(constructRectangle(4)));
        System.out.println(Arrays.toString(constructRectangle(17)));
        System.out.println(Arrays.toString(constructRectangle(18)));
        System.out.println(Arrays.toString(constructRectangle(19)));
    }
}
