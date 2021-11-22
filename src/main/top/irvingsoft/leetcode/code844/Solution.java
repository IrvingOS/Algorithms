package top.irvingsoft.leetcode.code844;

/**
 * 比较含退格的字符串
 *
 * @author TimeChaser
 * @since 2021/11/22 18:01
 */
public class Solution {

    public boolean backspaceCompare(String s, String t) {
        int indexS = s.length() - 1;
        int indexT = t.length() - 1;
        while (indexS >= 0 || indexT >= 0) {
            int signCount = 0;
            while (indexS >= 0 && (signCount > 0 || s.charAt(indexS) == '#')) {
                if (s.charAt(indexS) == '#') {
                    signCount++;
                } else {
                    signCount--;
                }
                indexS--;
            }
            signCount = 0;
            while (indexT >= 0 && (signCount > 0 || t.charAt(indexT) == '#')) {
                if (t.charAt(indexT) == '#') {
                    signCount++;
                } else {
                    signCount--;
                }
                indexT--;
            }
            // "nzp#o#g"
            // "b#nzp#o#g"
            // 在匹配完 nzp 之后， str2 还剩 "b#"，需要再给 str2 一次机会来退格，如果最后还剩 "b"，那就不可能匹配了
            if (indexS >= 0 && indexT >= 0) {
                if (s.charAt(indexS) != t.charAt(indexT)) {
                    return false;
                }
            } else {
                if (indexS >= 0 || indexT >= 0) {
                    return false;
                }
            }
            indexS--;
            indexT--;
        }
        return true;
    }
}
