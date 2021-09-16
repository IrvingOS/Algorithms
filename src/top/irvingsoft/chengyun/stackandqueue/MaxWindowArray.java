package top.irvingsoft.chengyun.stackandqueue;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Page 37
 *
 * @author TimeChaser
 * @date 2021/9/7 22:43
 */
public class MaxWindowArray {

    public static int[] getMaxWindow(int[] arr, int w) {

        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qMax = new LinkedList<>();
        int index = 0;
        int[] res = new int[arr.length - w + 1];
        for (int i = 0; i < arr.length; i++) {
            while (!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[i]) {
                qMax.pollLast();
            }
            qMax.addLast(i);
            // 队头仍为最大值，但是下标已过期
            if (qMax.peekFirst() == i - w) {
                qMax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qMax.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(getMaxWindow(new int[]{5, 3, 2, 1, 9, 10, 4, 8, 6, 7}, 4)));
    }
}
