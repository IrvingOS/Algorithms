package top.irvingsoft.code.sort;

import java.util.Arrays;

/**
 * @author TimeChaser
 * @since 2021/10/13 14:31
 */
public class QuickSort implements IArraySort {

    public static void main(String[] args) {

        int[] arr = {22, 34, 3, 32, 82, 55, 89, 50, 37, 5, 64, 35, 9, 70};
        System.out.println(Arrays.toString(new QuickSort().sort(arr)));
    }

    @Override
    public int[] sort(int[] sourceArray) {
        return sourceArray;
    }

}
