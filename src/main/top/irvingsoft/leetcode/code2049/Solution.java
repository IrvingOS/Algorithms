package top.irvingsoft.leetcode.code2049;

import java.util.ArrayList;
import java.util.List;

/**
 * 统计最高分的节点数目
 *
 * @author TimeChaser
 * @since 2022/3/11 11:16 AM
 */
public class Solution {

    private int n;
    private long maxScore;
    private int result;
    private List<Integer>[] children;

    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        children = new List[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int p = parents[i];
            if (p != -1) {
                children[p].add(i);
            }
        }
        dfs(0);
        return result;
    }

    private int dfs(int node) {
        long score = 1;
        int remain = n - 1;
        for (int child : children[node]) {
            int t = dfs(child);
            score *= t;
            remain -= t;
        }
        if (remain != 0) {
            score *= remain;
        }
        if (score > maxScore) {
            maxScore = score;
            result = 1;
        } else if (score == maxScore) {
            result++;
        }
        return n - remain;
    }
}
