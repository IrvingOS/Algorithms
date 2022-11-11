package top.irvingsoft.leetcode.code1704;

import java.util.HashSet;
import java.util.Set;

/*
 * 判断字符串的两半是否相似
 */
public class Solution {

    Set<Character> set = new HashSet<Character>() {{
        add('a');
        add('e');
        add('i');
        add('o');
        add('u');
        add('A');
        add('E');
        add('I');
        add('O');
        add('U');
    }};

    public boolean halvesAreAlike(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int preCount = 0;
        int sufCount = 0;
        for(int i = 0; i < n / 2; i++) {
            preCount += isAn(arr[i]) ? 1 : 0;
            sufCount += isAn(arr[i + n / 2]) ? 1 : 0;
        }
        return preCount == sufCount;
    }

    private boolean isAn(char c) {
        return set.contains(c);
    }
}
