package top.irvingsoft.leetcode.code438;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 *
 * @author TimeChaser
 * @since 2021/11/23 17:14
 */
public class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
        }
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            int countIndexRight = s.charAt(right) - 'a';
            sCount[countIndexRight]++;
            while (sCount[countIndexRight] > pCount[countIndexRight]) {
                sCount[s.charAt(left) - 'a']--;
                left++;
            }
            if (right - left + 1 == p.length()) {
                result.add(left);
                sCount[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }
        return result;
    }
}
