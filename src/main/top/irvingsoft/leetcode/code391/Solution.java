package top.irvingsoft.leetcode.code391;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 完美矩形
 *
 * @author TimeChaser
 * @since 2021/11/16 8:58
 */
public class Solution {

    public static boolean isRectangleCover(int[][] rectangles) {
        int n = rectangles.length;
        int sideLength = n * 2;
        int[][] sides = new int[sideLength][4];
        for (int i = 0, index = 0; i < n; i++) {
            int[] rectangle = rectangles[i];
            sides[index++] = new int[]{rectangle[0], rectangle[1], rectangle[3], 1};
            sides[index++] = new int[]{rectangle[2], rectangle[1], rectangle[3], -1};
        }
        Arrays.sort(sides, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        List<int[]> leftSides = new ArrayList<>();
        List<int[]> rightSides = new ArrayList<>();
        for (int left = 0; left < sideLength; ) {
            int right = left + 1;
            while (right < sideLength && sides[right][0] == sides[left][0]) {
                right++;
            }
            leftSides.clear();
            rightSides.clear();
            for (int i = left; i < right; i++) {
                int[] side = sides[i];
                int[] cur = new int[]{side[1], side[2]};
                List<int[]> curSides = side[3] == 1 ? leftSides : rightSides;
                if (curSides.isEmpty()) {
                    curSides.add(cur);
                } else {
                    int[] prev = curSides.get(curSides.size() - 1);
                    if (cur[0] < prev[1]) {
                        // 边重叠
                        return false;
                    } else if (cur[0] == prev[1]) {
                        // 边连接，直接由前面已入列表的边延长
                        prev[1] = cur[1];
                    } else {
                        // 边未连接，入列表
                        curSides.add(cur);
                    }
                }
            }
            if (left > 0 && right < sideLength) {
                if (leftSides.size() != rightSides.size()) {
                    // 左右边经过延长后，如果数量不相等，则不是完美矩形
                    return false;
                }
                // 比较左右各边是否长度相等
                for (int i = 0; i < leftSides.size(); i++) {
                    if (leftSides.get(i)[0] != rightSides.get(i)[0] || leftSides.get(i)[1] != rightSides.get(i)[1]) {
                        return false;
                    }
                }
            } else {
                if (leftSides.size() + rightSides.size() != 1) {
                    // 如果构成完美矩形，则左边界与右边界只存在一条记录（边连接后会直接由先入列表的边延长）
                    return false;
                }
            }
            left = right;
        }
        return true;
    }

}
