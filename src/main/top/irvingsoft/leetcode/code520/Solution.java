package top.irvingsoft.leetcode.code520;

/**
 * 检测大写字母
 *
 * @author TimeChaser
 * @since 2021/11/13 7:58
 */
public class Solution {

    public static boolean detectCapitalUse(String word) {
        boolean allUpCase = false;
        boolean firstUpCase = false;
        for (int i = 0; i < word.toCharArray().length; i++) {
            if (i == 0 && Character.isUpperCase(word.charAt(i))) {
                firstUpCase = true;
                continue;
            }
            if (i == 1 && Character.isUpperCase(word.charAt(i))) {
                if (!firstUpCase) {
                    return false;
                }
                allUpCase = true;
                continue;
            }
            if (!allUpCase && Character.isUpperCase(word.charAt(i))) {
                return false;
            }
            if (allUpCase && Character.isLowerCase(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("USA"));
        System.out.println(detectCapitalUse("leetcode"));
        System.out.println(detectCapitalUse("Google"));
        System.out.println(detectCapitalUse("FlaG"));
    }
}
