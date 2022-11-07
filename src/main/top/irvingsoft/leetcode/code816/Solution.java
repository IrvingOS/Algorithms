package top.irvingsoft.leetcode.code816;

import java.util.ArrayList;
import java.util.List;

/*
 * 模糊坐标
 */
public class Solution {

    public List<String> ambiguousCoordinates(String s) {
        int n = s.length() - 2;
        List<String> result = new ArrayList<>();
        s = s.substring(1, s.length() - 1);
        for (int i = 1; i < n; i++) {
            List<String> lefts = getDouble(s.substring(0, i));
            if (lefts.isEmpty()) {
                continue;
            }
            List<String> rights = getDouble(s.substring(i));
            if (rights.isEmpty()) {
                continue;
            }
            for (String left : lefts) {
                for (String right : rights) {
                    result.add("(" + left + ", " + right + ")" );
                }
            }
        }
        return result;
    }

    private List<String> getDouble(String s) {
        int n = s.length();
        List<String> doubles = new ArrayList<>();
        if (s.charAt(0) != '0' || "0".equals(s)) {
            doubles.add(s);
        }
        for (int i = 1; i < n; i++) {
            /*i = 2 09.1 , i = 1 0.910 这两种情况是不能加 . 的*/
            if ((i != 1 && s.charAt(0) == '0') || s.charAt(s.length() - 1) == '0') {
                continue;
            }
            doubles.add(s.substring(0, i) + "." + s.substring(i));
        }
        return doubles;
    }
}
