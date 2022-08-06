package top.irvingsoft.leetcode.code969;

import java.util.ArrayList;
import java.util.List;

/**
 * 煎饼排序
 *
 * @author TimeChaser
 * @since 2022/2/19 9:43
 */
public class Solution {

    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> result = new ArrayList<>();
        for (int n = arr.length; n > 1; n--) {
            int index = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] > arr[index]) {
                    index = i;
                }
            }
            if (index == n - 1) {
                continue;
            }
            reverse(arr, index);
            reverse(arr, n - 1);
            result.add(index + 1);
            result.add(n);
        }
        return result;
    }

    private void reverse(int[] arr, int end) {
        for (int i = 0, j = end; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

}
