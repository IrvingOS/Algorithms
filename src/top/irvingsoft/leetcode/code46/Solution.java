package top.irvingsoft.leetcode.code46;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 全排列
 *
 * @author TimeChaser
 * @date 2021/10/29 16:19
 */
public class Solution {

    public static List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();

        ArrayList<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        backtrack(nums.length, output, result, 0);
        return result;
    }

    public static void backtrack(int n, List<Integer> output, List<List<Integer>> result, int first) {
        if (first == n) {
            result.add(new ArrayList<>(output));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(output, first, i);
            backtrack(n, output, result, first + 1);
            Collections.swap(output, first, i);
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 2, 3}));
    }
}
