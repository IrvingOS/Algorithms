package top.irvingsoft.leetcode.code500;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 键盘行
 *
 * @author TimeChaser
 * @since 2021/10/31 10:17
 */
public class Solution {

    private static final char[][] CH = new char[][]{
            {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
            {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'},
            {'z', 'x', 'c', 'v', 'b', 'n', 'm'}};

    public static String[] findWords(String[] words) {
        ArrayList<String> result = new ArrayList<>();
        for (String word : words) {
            int[] indexes = new int[word.length()];
            int index = 0;
            for (char c : word.toLowerCase().toCharArray()) {
                for (int i = 0; i < CH.length; i++) {
                    for (int j = 0; j < CH[i].length; j++) {
                        if (CH[i][j] == c) {
                            indexes[index++] = i;
                        }
                    }
                }
            }
            index = indexes[0];
            boolean flag = true;
            for (int i : indexes) {
                if (index != i) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(word);
            }
        }
        return result.toArray(new String[0]);
    }

    public static String[] findWordsAnother(String[] words) {
        ArrayList<String> result = new ArrayList<>();
        String rowIndex = "12210111011122000010020202";
        for (String word : words) {
            boolean valid = true;
            int index = rowIndex.charAt(word.toLowerCase().charAt(0) - 'a');
            for (int i = 1; i < word.toLowerCase().length(); i++) {
                if (rowIndex.charAt(word.toLowerCase().charAt(i) - 'a') != index) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                result.add(word);
            }
        }
        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findWordsAnother(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
    }
}
