package top.irvingsoft.leetcode.code1601;

/**
 * 最多可达成的换楼请求数目
 *
 * @author TimeChaser
 * @since 2022/2/28 10:54
 */
public class Solution {

    private int result = 0;

    public int maximumRequests(int n, int[][] requests) {
        dfs(0, 0, 0, 0, requests, new int[n], new int[n]);
        return result;
    }

    private void dfs(int index, int from, int to, int n, int[][] requests, int[] fromCount, int[] toCount) {
        if (from == to) {
            boolean flag = true;
            for (int i = 0; i < fromCount.length; i++) {
                if (fromCount[i] != toCount[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result = Math.max(result, n);
            }
        }
        if (index < requests.length) {
            fromCount[requests[index][0]]++;
            toCount[requests[index][1]]++;
            dfs(index + 1, from ^ requests[index][0], to ^ requests[index][1], n + 1, requests, fromCount, toCount);
            fromCount[requests[index][0]]--;
            toCount[requests[index][1]]--;
            dfs(index + 1, from, to, n, requests, fromCount, toCount);
        }
    }

}
