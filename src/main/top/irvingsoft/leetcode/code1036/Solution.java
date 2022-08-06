package top.irvingsoft.leetcode.code1036;

import java.util.HashSet;
import java.util.Set;

/**
 * 逃离大迷宫
 *
 * @author TimeChaser
 * @since 2022/1/12 11:42
 */
public class Solution {

    private final long base = 131L;

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<Long> blockSet = new HashSet<>();
        for (int[] ints : blocked) {
            blockSet.add(ints[0] * base + ints[1]);
        }
        return dfs(source, target, source[0], source[1], blockSet, new HashSet<>()) &&
               dfs(target, source, target[0], target[1], blockSet, new HashSet<>());
    }

    private boolean dfs(int[] source, int[] target, int i, int j, Set<Long> blocked, Set<Long> visited) {
        if (i == target[0] && j == target[1]) {
            return true;
        }
        long hash = i * base + j;
        if (i < 0 || j < 0 || i >= 1e6 || j >= 1e6 || blocked.contains(hash) || visited.contains(hash)) {
            return false;
        }
        if (Math.abs(source[0] - i) + Math.abs(source[1] - j) > 200) {
            return true;
        }
        visited.add(hash);
        return dfs(source, target, i - 1, j, blocked, visited) || dfs(source, target, i + 1, j, blocked, visited) ||
               dfs(source, target, i, j - 1, blocked, visited) || dfs(source, target, i, j + 1, blocked, visited);
    }

}
