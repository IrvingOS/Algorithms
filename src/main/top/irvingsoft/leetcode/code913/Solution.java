package top.irvingsoft.leetcode.code913;

import java.util.Arrays;

/**
 * 猫和老鼠
 *
 * @author TimeChaser
 * @since 2022/1/4 11:27
 */
public class Solution {

    private final int       DRAW      = 0;
    private final int       MOUSE_WIN = 1;
    private final int       CAT_WIN   = 2;
    private       int       n;
    private       int[][]   graph;
    private       int[][][] dp;

    public int catMouseGame(int[][] graph) {
        this.n = graph.length;
        this.graph = graph;
        this.dp = new int[n][n][n * 2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return getResult(1, 2, 0);
    }

    private void getNextResult(int mouse, int cat, int turns) {
        int cur = turns % 2 == 0 ? mouse : cat;
        int worstResult = cur == cat ? MOUSE_WIN : CAT_WIN;
        int result = worstResult;
        for (int next : graph[cur]) {
            if (next == 0 && cur == cat) {
                continue;
            }
            int nextMouse = cur == mouse ? next : mouse;
            int nextCat = cur == cat ? next : cat;
            int nextResult = getResult(nextMouse, nextCat, turns + 1);
            if (nextResult != worstResult) {
                result = nextResult;
                if (result != DRAW) {
                    break;
                }
            }
        }
        dp[mouse][cat][turns] = result;
    }

    private int getResult(int mouse, int cat, int turns) {
        if (turns == n * 2) {
            return DRAW;
        }
        if (dp[mouse][cat][turns] < 0) {
            if (mouse == 0) {
                return MOUSE_WIN;
            } else if (cat == mouse) {
                return CAT_WIN;
            } else {
                getNextResult(mouse, cat, turns);
            }
        }
        return dp[mouse][cat][turns];
    }
}
