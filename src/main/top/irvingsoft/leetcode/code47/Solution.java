package top.irvingsoft.leetcode.code47;

import java.util.*;

/**
 * 全排列 2
 *
 * @author TimeChaser
 * @since 2021/10/29 16:55
 */
public class Solution {

    public static List<List<Integer>> permuteUniqueSet(int[] nums) {
        HashSet<List<Integer>> result = new HashSet<>();

        ArrayList<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        backtrackSet(0, nums.length, output, result);
        return new ArrayList<>(result);
    }

    public static void backtrackSet(int first, int n, List<Integer> output, Set<List<Integer>> result) {
        if (first == n) {
            result.add(new ArrayList<>(output));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(output, i, first);
            backtrackSet(first + 1, n, output, result);
            Collections.swap(output, i, first);
        }
    }

    /**
     * 先排序，然后限制相同的数的使用顺序
     * <p>
     * 即：对于有两个相同的数，前一个数被先使用时组合出的数组与后一个数被先使用时组合出的数组一样。
     * <p>
     * 于是，在使用后面的相同数时，通过判断前面的相同数是否已经被先使用。
     * 前面的相同数未被先使用时，使用后面的相同数组合出的数组将与此前的相同数组合出的数组重复
     * 前面的相同数被先使用时，此时使用后面的相同数是前面的相同数在组合数组
     */
    public static List<List<Integer>> permuteUniqueStatus(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> output = new ArrayList<>();
        boolean[] status = new boolean[nums.length];
        Arrays.sort(nums);
        backtrackStatus(0, nums, status, output, result);
        return result;
    }

    public static void backtrackStatus(int index, int[] nums, boolean[] status, List<Integer> output, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(output));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (status[i] || (i > 0 && nums[i] == nums[i - 1] && !status[i - 1])) {
                continue;
            }
            output.add(nums[i]);
            status[i] = true;
            backtrackStatus(index + 1, nums, status, output, result);
            output.remove(index);
            status[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(permuteUniqueStatus(new int[]{1, 1, 1}));
    }
}
