package top.irvingsoft.leetcode.code1078;

import java.util.ArrayList;
import java.util.List;

/**
 * Bigram 分词
 *
 * @author TimeChaser
 * @since 2021/12/26 13:24
 */
public class Solution {

    public String[] findOcurrences(String text, String first, String second) {
        String[] splits = text.split(" ");
        List<String> list = new ArrayList<>();
        for (int i = 2; i < splits.length; i++) {
            if (splits[i - 2].equals(first) && splits[i - 1].equals(second)) {
                list.add(splits[i]);
            }
        }
        String[] result = new String[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

}
