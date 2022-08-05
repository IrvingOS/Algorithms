package top.irvingsoft.leetcode.code1408;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组中的字符串匹配
 *
 * @author TimeChaser
 * @since 5/8/2022 下午9:41
 */
public class Solution {

    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }

}
