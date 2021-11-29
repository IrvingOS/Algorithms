package top.irvingsoft.code.sort;

import java.util.Arrays;

public class SelectionSort implements IArraySort {

    public static void main(String[] args) {

        int[] arr = {22, 34, 3, 32, 82, 55, 89, 50, 37, 5, 64, 35, 9, 70};
        System.out.println(Arrays.toString(new SelectionSort().sort(arr)));
    }

    @Override
    public int[] sort(int[] sourceArray) {
        return sourceArray;
    }
}
