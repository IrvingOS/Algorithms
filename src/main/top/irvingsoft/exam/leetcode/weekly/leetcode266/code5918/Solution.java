package top.irvingsoft.exam.leetcode.weekly.leetcode266.code5918;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 统计字符串中的元音子字符串
 *
 * @author TimeChaser
 * @since 2021/11/7 10:33
 */
public class Solution {

    private static final List<Character> list = new ArrayList<>();

    static {
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');
    }

    public static int countVowelSubstrings(String word) {
        int n = word.length();
        int length = 5;
        if (n < length) {
            return 0;
        }
        int result = 0;
        while (length <= n) {
            for (int i = 0; i < n - length + 1; i++) {
                if (isValid(word.substring(i, i + length))) {
                    result++;
                }
            }
            length++;
        }
        return result;
    }

    public static boolean isValid(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (Character character : list) {
            if (!map.containsKey(character)) {
                return false;
            }
            map.remove(character);
        }
        return map.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(countVowelSubstrings("aeiouu"));
        System.out.println(countVowelSubstrings("unicornarihan"));
        System.out.println(countVowelSubstrings("cuaieuouac"));
        System.out.println(countVowelSubstrings("bbaeixoubb"));
    }
}
