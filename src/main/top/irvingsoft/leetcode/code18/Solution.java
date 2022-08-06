package top.irvingsoft.leetcode.code18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 *
 * @author TimeChaser
 * @since 2022/1/6 11:44
 */
public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target) {
                    continue;
                }
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    int compareTo = nums[i] + nums[j] + nums[k] + nums[l] - target;
                    if (compareTo < 0) {
                        k++;
                    } else if (compareTo > 0) {
                        l--;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        while (k < l && nums[k] == nums[k + 1]) {
                            k++;
                        }
                        k++;
                        while (k < l && nums[l] == nums[l - 1]) {
                            l--;
                        }
                        l--;
                    }
                }
            }
        }
        return result;
    }

}
