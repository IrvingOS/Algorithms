package top.irvingsoft.foroffer.code3;

/**
 * 数组中的重复数字
 * <p>
 * 1. HashSet 省略
 * <p>
 * 2. 原地交换
 *
 * @author TimeChaser
 * @since 2021/11/24 21:07
 */
public class Solution {

    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (i == nums[i]) {
                i++;
                continue;
            }
            if (nums[i] == nums[nums[i]]) {
                return nums[i];
            }
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
        }
        return -1;
    }
}
