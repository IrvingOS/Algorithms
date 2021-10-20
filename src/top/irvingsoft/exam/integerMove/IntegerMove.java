package top.irvingsoft.exam.integerMove;

import java.util.Arrays;

/**
 * 正数左移，负数右移
 * <p>
 * 要求时间复杂度 O(n)，空间复杂度 O(1)
 * <p>
 * 本解法使用双指针：一个从前往后搜索负数，一个从后往前搜索正数。然后判断是否走完全程，否，则交换
 *
 * @author TimeChaser
 * @author TimeChaser
 * @date 2021/9/26 19:36
 */
public class IntegerMove {

    public static void move(int[] arr) {

        int begin = 0, end = arr.length - 1;
        while (true) {
            while (begin < arr.length && arr[begin] >= 0) {
                begin++;
            }
            while (end >= 0 && arr[end] < 0) {
                end--;
            }
            if (begin > end) {
                break;
            }
            swap(arr, begin, end);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] ints = {6, -10, 4, -3, 5, -2, -1, 0, 1, -9};
        move(ints);
        System.out.println(Arrays.toString(ints));
    }
}