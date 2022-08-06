package top.irvingsoft.exam.leetcode.weekly.leetcode271.code5955;

import java.util.HashMap;
import java.util.Map;

/**
 * 摘水果
 *
 * @author TimeChaser
 * @since 2021/12/12 11:41
 */
public class Solution {

    private int k;
    private int max;

    public static void main(String[] args) {
        System.out.println(new Solution().maxTotalFruitsBacktrack(new int[][]{{200000, 10000}}, 200000, 200000));
    }

    /**
     * TODO 加权图欧拉路径模板
     */
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int totalPos = fruits[n - 1][0];
        if (startPos - k > totalPos) {
            return 0;
        }
        int[] sum = new int[totalPos + 1];
        int ret = 0;
        for (int i = 0; i < n; i++) {
            sum[fruits[i][0]] = fruits[i][1];
        }
        for (int i = 1; i < totalPos + 1; i++) {
            sum[i] += sum[i - 1];
        }
        // 这里不掉头
        if (startPos <= totalPos) {
            ret = Math.max(ret, (startPos + k > totalPos ? sum[totalPos] : sum[startPos + k]) -
                                (startPos > 0 ? sum[startPos - 1] : 0));
            ret = Math.max(ret, sum[startPos] - (startPos - k > 0 ? sum[startPos - k - 1] : 0));
        } else {
            if (startPos - k <= totalPos) {
                ret = Math.max(ret, sum[totalPos] - (startPos - k > 0 ? sum[startPos - k - 1] : 0));
            }
        }
        //枚举调头的点
        for (int i = 0; i <= totalPos; i++) {
            int r = 0, l = 0;
            if (i < startPos) {
                if (startPos - i > k) {
                    continue;
                }
                r = i + (k - (startPos - i));
                l = i;
            } else if (i > startPos) {
                if (i - startPos > k) {
                    break;
                }
                r = i;
                l = i - (k - (i - startPos));
            }
            r = Math.min(r, totalPos);
            if (r < l || (r == l && r == 0)) {
                continue;
            }
            ret = Math.max(ret, sum[r] - (l > 0 ? sum[l - 1] : 0));
        }
        return ret;
    }

    /**
     * 回溯
     * <p>
     * 超时
     */
    public int maxTotalFruitsBacktrack(int[][] fruits, int startPos, int k) {
        this.k = k;
        Map<Integer, Integer> map = new HashMap<>();
        int maxIndex = 0;
        for (int[] fruit : fruits) {
            map.put(fruit[0], fruit[1]);
            maxIndex = fruit[0];
        }
        backtrack(map, new boolean[maxIndex + 1], startPos, 0, 0, 0);
        return max;
    }

    private void backtrack(Map<Integer, Integer> fruits, boolean[] status, int curPos, int left, int right, int count) {
        if (left + right > k || curPos < 0 || curPos >= status.length) {
            max = Math.max(max, count);
            return;
        }
        if (!status[curPos]) {
            status[curPos] = true;
            backtrack(fruits, status, curPos - 1, left + 1, right, count + fruits.getOrDefault(curPos, 0));
            backtrack(fruits, status, curPos + 1, left, right + 1, count + fruits.getOrDefault(curPos, 0));
            status[curPos] = false;
        } else {
            backtrack(fruits, status, curPos - 1, left + 1, right, count);
            backtrack(fruits, status, curPos + 1, left, right + 1, count);
        }
    }

}
