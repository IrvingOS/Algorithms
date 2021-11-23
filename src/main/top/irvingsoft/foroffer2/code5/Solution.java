package top.irvingsoft.foroffer2.code5;

/**
 * 替换空格
 *
 * @author TimeChaser
 * @since 2021/11/23 18:50
 */
public class Solution {

    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }

    public String replaceSpaceAnother(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
