package top.irvingsoft.leetcode.code838;

import java.util.*;

/**
 * 推多米诺
 *
 * @author TimeChaser
 * @since 2022/2/21 10:27
 */
public class Solution {

    public String pushDominoesBFS(String dominoes) {
        int n = dominoes.length();
        int[] time = new int[n];
        List<Character>[] force = new List[n];
        Deque<Integer> queue = new ArrayDeque<>();
        Arrays.fill(time, -1);
        for (int i = 0; i < n; i++) {
            force[i] = new ArrayList<>();
            char f = dominoes.charAt(i);
            if (f != '.') {
                time[i] = 0;
                queue.offer(i);
                force[i].add(f);
            }
        }
        char[] result = new char[n];
        Arrays.fill(result, '.');
        while (!queue.isEmpty()) {
            int i = queue.poll();
            if (force[i].size() == 1) {
                char f = force[i].get(0);
                result[i] = f;
                int ni = f == 'L' ? i - 1 : i + 1;
                if (ni >= 0 && ni < n) {
                    int t = time[i];
                    if (time[ni] == -1) {
                        time[ni] = t + 1;
                        force[ni].add(f);
                        queue.offer(ni);
                    } else if (time[ni] == t + 1) {
                        force[ni].add(f);
                    }
                }
            }
        }
        return new String(result);
    }

    public String pushDominoesSimulation(String dominoes) {
        char[] arr = dominoes.toCharArray();
        int n = arr.length;
        char left = 'L';
        for (int i = 0; i < n; ) {
            int j = i;
            while (j < n && arr[j] == '.') {
                j++;
            }
            char right = j < n ? arr[j] : 'R';
            if (left == right) {
                while (i < j) {
                    arr[i++] = left;
                }
            } else if (left == 'R' && right == 'L') {
                int k = j - 1;
                while (i < k) {
                    arr[i++] = 'R';
                    arr[k--] = 'L';
                }
            }
            left = right;
            i = j + 1;
        }
        return new String(arr);
    }
}
