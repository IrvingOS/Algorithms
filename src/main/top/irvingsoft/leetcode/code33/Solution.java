package top.irvingsoft.leetcode.code33;

/**
 * 搜索旋转排序数组
 *
 * @author TimeChaser
 * @since 2021/11/12 15:02
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 6));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 7));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 8));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 1));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2));
        System.out.println(search(new int[]{1}, 0));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[left]) {
                if (nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}
