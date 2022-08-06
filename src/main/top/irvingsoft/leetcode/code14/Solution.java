package top.irvingsoft.leetcode.code14;

/**
 * 最长公共前缀
 *
 * @author TimeChaser
 * @since 2021/4/6 11:08
 */
public class Solution {

    public static boolean isCommonPrefix(String[] strs, int length) {
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            for (int j = 0; j < length; j++) {
                if (str.charAt(j) != strs[0].charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 二分查找：对最短字符串的长度进行二分
     * <p>
     * + 1：保证最高位能被验证到是否属于最长公共前缀
     *
     * @since 2021/4/8 12:56
     */
    public static String longestCommonPrefixBinary(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        // leets leetcode leetc leetsc
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        int low = 0, high = minLength;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (isCommonPrefix(strs, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, low);
    }

    public static String longestCommonPrefixDivide(String left, String right) {
        int length = Math.min(left.length(), right.length());
        for (int i = 0; i < length; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, length);
    }

    /**
     * 分治法；递归二分查找出最小一段（两个）字符串的最长公共前缀，然后依次返回
     *
     * @since 2021/4/8 11:23
     */
    public static String longestCommonPrefixDivide(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        } else {
            return longestCommonPrefixDivide(strs, 0, strs.length - 1);
        }
    }

    public static String longestCommonPrefixDivide(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        } else {
            int mid = (end - start) / 2 + start;
            String leftCommonPrefix = longestCommonPrefixDivide(strs, start, mid);
            String rightCommonPrefix = longestCommonPrefixDivide(strs, mid + 1, end);
            return longestCommonPrefixDivide(leftCommonPrefix, rightCommonPrefix);
        }

    }

    /**
     * 纵向比较：取第一个字符串，将其的每个下表的字符同后面的字符串进行比较，不同则返回
     *
     * @since 2021/4/7 13:31
     */
    public static String longestCommonPrefixLongitudinal(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        int length = strs[0].length();
        int count = strs.length;

        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /**
     * 横向比较：设第一个字符串为初始最长公共前缀，然后与第二个开始比较，每次得到的最长公共前缀依次与后面的字符串比较。当最长公共前缀为空字符串时退出比较。
     *
     * @since 2021/4/8 11:13
     */
    public static String longestCommonPrefixTransverse(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String commonPrefix = strs[0];
        int count = strs.length;

        for (int i = 1; i < count; i++) {
            commonPrefix = longestCommonPrefixTransverse(commonPrefix, strs[i]);
            if ("".equals(commonPrefix)) {
                break;
            }
        }
        return commonPrefix;
    }

    public static String longestCommonPrefixTransverse(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

    public static void main(String[] args) {
        String[] strings = new String[]{" ba ", " ba s"};
        char c = '中';
        System.out.println(c);
        String s = "中华人民共和国";
        System.out.println(s.substring(0, 2));
        System.out.println(longestCommonPrefixBinary(strings));
    }

}
