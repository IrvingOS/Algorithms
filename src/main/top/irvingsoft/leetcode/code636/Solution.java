package top.irvingsoft.leetcode.code636;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * 函数的独占时间
 * <p>
 * 栈 + 分区结算
 *
 * @author TimeChaser
 * @since 6/8/2022 下午5:31
 */
public class Solution {

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Deque<int[]> stack = new ArrayDeque<>();
        for (String log : logs) {
            int index = Integer.parseInt(log.substring(0, log.indexOf(":")));
            int timestamp = Integer.parseInt(log.substring(log.lastIndexOf(":") + 1));
            if (log.contains("start")) {
                if (!stack.isEmpty()) {
                    result[stack.peek()[0]] += timestamp - stack.peek()[1];
                }
                stack.push(new int[]{index, timestamp});
            } else {
                int[] left = stack.pop();
                result[left[0]] += timestamp - left[1] + 1;
                if (!stack.isEmpty()) {
                    stack.peek()[1] = timestamp + 1;
                }
            }
        }
        return result;
    }

}
