package top.irvingsoft.leetcode.code49;

import java.util.*;

/**
 * 字母异位词分组
 *
 * @author TimeChaser
 * @since 2021/11/3 11:01
 */
public class Solution {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>(strs.length);
        for (String str : strs) {
            String sorted = sort(str);
            List<String> list = map.getOrDefault(sorted, new ArrayList<>());
            list.add(str);
            map.put(sorted, list);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static String sort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}
