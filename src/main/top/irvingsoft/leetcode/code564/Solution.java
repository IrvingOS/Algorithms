package top.irvingsoft.leetcode.code564;

import java.util.ArrayList;
import java.util.List;

/**
 * 寻找最近的回文数
 *
 * @author TimeChaser
 * @since 2022/3/2 22:40
 */
public class Solution {

    public String nearestPalindromic(String n) {
        long result = -1;
        long source = Long.parseLong(n);
        List<Long> candidates = getCandidates(n);
        for (Long candidate : candidates) {
            if (candidate != source) {
                if (result == -1
                        || Math.abs(candidate - source) < Math.abs(result - source)
                        || Math.abs(candidate - source) == Math.abs(result - source) && candidate < result) {
                    result = candidate;
                }
            }
        }
        return Long.toString(result);
    }

    private List<Long> getCandidates(String source) {
        int n = source.length();
        List<Long> candidates = new ArrayList<Long>() {{
            add((long) (Math.pow(10, n - 1) - 1));
            add((long) (Math.pow(10, n) + 1));
        }};
        long suffix = Long.parseLong(source.substring(0, (n + 1) / 2));
        for (long i = suffix - 1; i <= suffix + 1; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append(new StringBuilder(sb).reverse().substring(n & 1));
            candidates.add(Long.parseLong(sb.toString()));
        }
        return candidates;
    }
}
