package top.irvingsoft.leetcode.code71;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 简化路径
 *
 * @author TimeChaser
 * @since 2021/11/5 17:49
 */
public class Solution {

    public String simplifyPath(String path) {
        Deque<String> deque = new ArrayDeque<>();
        for (String split : path.split("/")) {
            if ("..".equals(split)) {
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
            } else if (split.length() != 0 && !".".equals(split)) {
                deque.offer(split);
            }
        }
        StringBuilder sb = new StringBuilder();
        if (deque.isEmpty()) {
            sb.append('/');
        } else {
            while (!deque.isEmpty()) {
                sb.append('/').append(deque.poll());
            }
        }
        return sb.toString();
    }
}
