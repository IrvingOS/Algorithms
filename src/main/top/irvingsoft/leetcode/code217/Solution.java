package top.irvingsoft.leetcode.code217;

import java.util.HashSet;
import java.util.Set;

/**
 * 存在重复元素
 *
 * @author TimeChaser
 * @since 2021/11/15 10:14
 */
public class Solution {

    public boolean containsDuplicateHash(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicateSelectionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            if (j > 0 && nums[j - 1] == temp) {
                return true;
            }
            nums[j] = temp;
        }
        return false;
    }

}
