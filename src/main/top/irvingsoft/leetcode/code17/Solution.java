package top.irvingsoft.leetcode.code17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合
 *
 * @author TimeChaser
 * @since 2021/11/1 17:55
 */
public class Solution {

    private static final String[] DICT = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private static final Map<Character, String> DICT_MAP = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public static List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        result.add("");
        for (char indexCh : digits.toCharArray()) {
            String str = DICT[indexCh - '0' - 2];
            ArrayList<String> temp = new ArrayList<>();
            for (char ch : str.toCharArray()) {
                for (String s : result) {
                    temp.add(s + ch);
                }
            }
            result = temp;
        }
        return result;
    }

    public static List<String> letterCombinationsBacktrack(String digits) {
        ArrayList<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        backtrack(result, digits, 0, new StringBuilder());
        return result;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinationsBacktrack("223"));
    }

    private static void backtrack(ArrayList<String> result, String digits, int index, StringBuilder combination) {
        if (index == digits.length()) {
            result.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = DICT_MAP.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(result, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

}
