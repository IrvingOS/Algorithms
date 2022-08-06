package top.irvingsoft.leetcode.code1629;

/**
 * 按键持续时间最长的键
 *
 * @author TimeChaser
 * @since 2022/1/9 12:39
 */
public class Solution {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int n = releaseTimes.length;
        char result = keysPressed.charAt(0);
        int maxTime = releaseTimes[0];
        for (int i = 1; i < n; i++) {
            char key = keysPressed.charAt(i);
            int time = releaseTimes[i] - releaseTimes[i - 1];
            if (time > maxTime || (time == maxTime && key > result)) {
                result = key;
                maxTime = time;
            }
        }
        return result;
    }

}
