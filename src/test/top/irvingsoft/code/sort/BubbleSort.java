package top.irvingsoft.code.sort;

import java.util.Arrays;

/**
 * @author TimeChaser
 * @since 2021/10/13 15:16
 */
public class BubbleSort implements IArraySort {

    public static void main(String[] args) {

        int[] arr = {11, 91, 41, 10, 36, 14, 82, 8, 4, 5};
        System.out.println(Arrays.toString(new BubbleSort().sort(arr)));
    }

    @Override
    public int[] sort(int[] sourceArray) {
        return sourceArray;
    }

}
