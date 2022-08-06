package top.irvingsoft.leetcode.code260;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 只出现一次的数字 ⅲ
 *
 * @author TimeChaser
 * @since 2021/10/30 15:13
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(singleNumberBitOperate(new int[]{2, 1, 2, 3, 5, 1})));
    }

    public static int[] singleNumberBitOperate(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        // xor = 3 ^ 5
        // 计算出一个可以将两个只出现一次的数分成两组的值
        // 这里也可以通过 while 循环配合位运算，将初始值的为 1 的 lsb 不断左移计算出第一个 xor & lsb != 0 的值即为 lsb
        int lsb = xor == Integer.MIN_VALUE ? xor : xor & -xor;
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            // 通过异或运算，排除每组中重复出现的值
            if ((num & lsb) != 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        return new int[]{num1, num2};
    }

    public static int[] singleNumberHash(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] result = new int[2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                result[i++] = entry.getKey();
            }
        }
        return result;
    }

    public static int[] singleNumberStatus(int[] nums) {
        Arrays.sort(nums);
        int num1 = 0;
        int num2 = 0;
        boolean num1Valid = false;
        boolean num2Valid = false;
        for (int num : nums) {
            if (num1Valid && num == num1) {
                num1Valid = false;
            } else if (num2Valid && num == num2) {
                num2Valid = false;
            } else if (!num1Valid) {
                num1 = num;
                num1Valid = true;
            } else if (!num2Valid) {
                num2 = num;
                num2Valid = true;
            }
        }
        return new int[]{num1, num2};
    }

}
