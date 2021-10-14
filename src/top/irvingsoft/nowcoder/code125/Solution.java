package top.irvingsoft.nowcoder.code125;

import java.util.HashMap;

/**
 * @author TimeChaser
 * @date 2021/10/14 10:52
 */
public class Solution {

    /**
     * max length of the subarray sum = k
     * <p>
     * 思想：将前面计算过的和及其对应下标存储起来，后面的计算根据前面的和寻找匹配项的下标从而计算出长度
     *
     * @param arr int整型一维数组 the array
     * @param k   int整型 target
     * @return int整型
     */
    public static int maxLengthEqualK(int[] arr, int k) {

        if (arr == null || arr.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int length = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                length = Math.max(length, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return length;
    }

    public static int maxLengthEqualKViolence(int[] arr, int k) {

        if (arr == null || arr.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum > k) {
                    continue;
                }
                if (sum == k) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(maxLengthEqualK(new int[]{1, -2, 1, 1, 1}, 0));
    }
}
