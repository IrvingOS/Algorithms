package top.irvingsoft.leetcode.code870;

import java.util.*;

/*
 * 优势洗牌
 */
public class Solution {

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int length = nums1.length;
        Integer[] index1 = new Integer[length];
        Integer[] index2 = new Integer[length];
        for (int i = 0; i < length; i++) {
            index1[i] = i;
            index2[i] = i;
        }
        Arrays.sort(index1, Comparator.comparingInt(i -> nums1[i]));
        Arrays.sort(index2, Comparator.comparingInt(i -> nums2[i]));

        int[] result = new int[length];
        int left = 0, right = length - 1;
        for(int i = 0; i < length; i++) {
            if (nums1[index1[i]] > nums2[index2[left]]) {
                result[index2[left++]] = nums1[index1[i]];
            } else {
                result[index2[right--]] = nums1[index1[i]];
            }
        }
        return result;
    }
}
