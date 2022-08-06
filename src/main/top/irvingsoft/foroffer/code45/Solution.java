package top.irvingsoft.foroffer.code45;

import java.util.Random;

/**
 * 把数组排成最小的数
 *
 * @author TimeChaser
 * @since 2021/12/5 18:05
 */
public class Solution {

    private final Random random = new Random();

    public String minNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = Integer.toString(nums[i]);
        }
        quickSort(strings, 0, strings.length - 1);
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            sb.append(string);
        }
        return sb.toString();
    }

    private void quickSort(String[] strings, int left, int right) {
        if (left >= right) {
            return;
        }
        randomProcess(strings, left, right);
        String pivot = strings[left];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && (strings[j] + pivot).compareTo(pivot + strings[j]) >= 0) {
                j--;
            }
            strings[i] = strings[j];
            while (i < j && (strings[i] + pivot).compareTo(pivot + strings[i]) <= 0) {
                i++;
            }
            strings[j] = strings[i];
        }
        strings[i] = pivot;
        quickSort(strings, left, i - 1);
        quickSort(strings, i + 1, right);
    }

    private void randomProcess(String[] strings, int left, int right) {
        int pivot = random.nextInt(right - left + 1) + left;
        swap(strings, left, pivot);
    }

    private void swap(String[] strings, int left, int pivot) {
        String temp = strings[left];
        strings[left] = strings[pivot];
        strings[pivot] = temp;
    }

}
