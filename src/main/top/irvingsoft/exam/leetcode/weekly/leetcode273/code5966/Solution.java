package top.irvingsoft.exam.leetcode.weekly.leetcode273.code5966;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 还原原数组
 *
 * @author TimeChaser
 * @since 2021/12/26 14:50
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().recoverArrayAnother(new int[]{2, 10, 6, 4, 8, 12})));
    }

    public int[] recoverArray(int[] nums) {
        Arrays.sort(nums);
        int[] result = new int[nums.length / 2];
        for (int i = 1; ; i++) {
            if (nums[i] > nums[0] && (nums[i] - nums[0]) % 2 == 0) {
                ArrayDeque<Integer> deque = new ArrayDeque<>();
                for (int j = 0, k = 0; j < nums.length; j++) {
                    if (!deque.isEmpty() && deque.peek() == nums[j]) {
                        deque.poll();
                    } else if (k == result.length) {
                        break;
                    } else {
                        deque.offer(nums[j] + nums[i] - nums[0]);
                        result[k++] = nums[j] + (nums[i] - nums[0]) / 2;
                    }
                }
                if (deque.isEmpty()) {
                    return result;
                }
            }
        }
    }

    public int[] recoverArrayAnother(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 1; ; i++) {
            int k2 = nums[i] - nums[0];
            if (k2 == 0 || k2 % 2 != 0) {
                continue;
            }
            Queue<Integer> queue = new ArrayDeque<>();
            int[] result = new int[n / 2];
            int t = 0;
            for (int num : nums) {
                if (!queue.isEmpty() && queue.peek() == num) {
                    queue.poll();
                } else {
                    if (t >= n / 2) {
                        break;
                    }
                    queue.offer(num + k2);
                    result[t++] = num + k2 / 2;
                }
            }
            if (queue.isEmpty()) {
                return result;
            }
        }
    }
}
