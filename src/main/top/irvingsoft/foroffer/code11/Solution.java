package top.irvingsoft.foroffer.code11;

/**
 * 旋转数组的最小数字
 *
 * @author TimeChaser
 * @since 2021/11/27 15:44
 */
public class Solution {

    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] < numbers[right]) {
                right = mid;
            } else if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else {
                right--;
            }
        }
        return numbers[left];
    }

}
