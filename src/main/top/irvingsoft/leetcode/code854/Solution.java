package top.irvingsoft.leetcode.code854;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/*
 * 相似度为 K 的字符串
 */
public class Solution {

    public int kSimilarity(String s1, String s2) {
        int n = s1.length();
        Queue<Pair<String, Integer>> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.offer(new Pair<>(s1, 0));
        visited.add(s1);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<String, Integer> pair = queue.poll();
                String cur = pair.getKey();
                int pos = pair.getValue();
                if (cur.equals(s2)) {
                    return step;
                }
                while (pos < n && s2.charAt(pos) == cur.charAt(pos)) {
                    pos++;
                }
                for (int j = pos + 1; j < n; j++) {
                    if (s2.charAt(j) == cur.charAt(j)) {
                        continue;
                    }
                    if (s2.charAt(pos) == cur.charAt(j)) {
                        String swapped = swap(cur, j, pos);
                        if (!visited.contains(swapped)) {
                            visited.add(swapped);
                            queue.offer(new Pair<>(swapped, pos + 1));
                        }
                    }
                }
            }
            step++;
        }
        return step;
    }

    private String swap(String text, int i, int j) {
        char[] array = text.toCharArray();
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return new String(array);
    }
}
