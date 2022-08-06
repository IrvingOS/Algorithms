package top.irvingsoft.foroffer.code50;

/**
 * 只出现一次的字符
 *
 * @author TimeChaser
 * @since 2021/12/6 15:19
 */
public class Solution {

    public char firstUniqChar(String s) {
        char result = ' ';
        int min = Integer.MAX_VALUE;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int index = s.indexOf(ch);
            if (index != -1 && index == s.lastIndexOf(ch) && index < min) {
                min = index;
                result = ch;
            }
        }
        return result;
    }

}
