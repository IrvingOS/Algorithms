package top.irvingsoft.leetcode.code169;

/**
 * 多数元素
 *
 * @author TimeChaser
 * @since 2021/11/15 9:57
 */
public class Solution {

    public int majorityElement(int[] nums) {
        int hero = 0;
        int blood = 0;
        for (int num : nums) {
            if (blood == 0) {
                hero = num;
            }
            blood += hero == num ? 1 : -1;
        }
        return hero;
    }

}
