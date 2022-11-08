package top.irvingsoft.leetcode.code1864;

/*
 * 统计一致字符串的数目
 */
public class Solution {

    public int countConsistentStrings(String allowed, String[] words) {
        int[] status = new int[26];
        for (char a : allowed.toCharArray()) {
            status[a - 'a'] = 1;
        }
        int result = 0;
        for (String word : words) {
            boolean yes = true;
            for (char c : word.toCharArray()) {
                if (status[c - 'a'] == 0) {
                    yes = false;
                    break;
                }
            }
            result += yes ? 1 : 0;
        }
        return result;
    }
}
