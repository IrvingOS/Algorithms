package top.irvingsoft.leetcode.code748;

/**
 * 最短补全词
 *
 * @author TimeChaser
 * @since 2021/12/10 9:48
 */
public class Solution {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] count = new int[26];
        for (int i = 0; i < licensePlate.length(); i++) {
            char ch = licensePlate.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                count[ch - 'a']++;
            } else if (ch >= 'A' && ch <= 'Z') {
                count[ch - 'A']++;
            }
        }
        int index = -1;
        for (int i = 0; i < words.length; i++) {
            int[] cur = new int[26];
            for (int j = 0; j < words[i].length(); j++) {
                char ch = words[i].charAt(j);
                if (ch >= 'a' && ch <= 'z') {
                    cur[ch - 'a']++;
                } else if (ch >= 'A' && ch <= 'Z') {
                    cur[ch - 'A']++;
                }
            }
            boolean flag = true;
            for (int j = 0; j < 26; j++) {
                if (count[j] > cur[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag && (index < 0 || words[i].length() < words[index].length())) {
                index = i;
            }
        }
        return words[index];
    }

}
