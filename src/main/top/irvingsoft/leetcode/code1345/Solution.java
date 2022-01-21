package top.irvingsoft.leetcode.code1345;

import java.util.*;

/**
 * 跳跃游戏 ⅳ
 *
 * @author TimeChaser
 * @since 2022/1/21 11:14
 */
public class Solution {

    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> indexSameMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexSameMap.computeIfAbsent(arr[i], v -> new ArrayList<>()).add(i);
        }
        Set<Integer> visitedSet = new HashSet<>();
        Queue<int[]> queue = new ArrayDeque<>();
        visitedSet.add(0);
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int index = poll[0];
            int step = poll[1];
            if (index == n - 1) {
                return step;
            }
            step++;
            if (indexSameMap.containsKey(arr[index])) {
                for (Integer i : indexSameMap.get(arr[index])) {
                    if (visitedSet.add(i)) {
                        queue.offer(new int[]{i, step});
                    }
                }
                indexSameMap.remove(arr[index]);
            }
            if (index - 1 >= 0 && visitedSet.add(index - 1)) {
                queue.offer(new int[]{index - 1, step});
            }
            if (index + 1 < n && visitedSet.add(index + 1)) {
                queue.offer(new int[]{index + 1, step});
            }
        }
        return -1;
    }
}
