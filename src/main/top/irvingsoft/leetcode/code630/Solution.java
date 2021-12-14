package top.irvingsoft.leetcode.code630;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 课程表 ⅲ
 *
 * @author TimeChaser
 * @since 2021/12/14 9:55
 */
public class Solution {

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;
        for (int[] course : courses) {
            if (course[0] + time <= course[1]) {
                time += course[0];
                queue.offer(course[0]);
            } else if (!queue.isEmpty() && queue.peek() > course[0]) {
                time -= queue.poll() - course[0];
                queue.offer(course[0]);
            }
        }
        return queue.size();
    }
}
