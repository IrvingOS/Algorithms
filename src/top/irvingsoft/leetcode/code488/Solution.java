package top.irvingsoft.leetcode.code488;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 祖玛游戏
 *
 * @author TimeChaser
 * @since 2021/11/9 8:40
 */
public class Solution {

    private static final Map<String, Map<String, Integer>> MAP = new HashMap<>();
    private static int originalLength;

    public static int findMinStep(String board, String hand) {
        originalLength = hand.length();
        int result = dfs(board, hand);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static int dfs(String board, String hand) {
        if (MAP.containsKey(board)) {
            if (MAP.get(board).containsKey(hand)) {
                return MAP.get(board).get(hand);
            }
        }
        if (board.length() == 0) {
            int result = originalLength - hand.length();
            Map<String, Integer> handMap = MAP.getOrDefault(board, new HashMap<>());
            handMap.put(hand, result);
            MAP.put(board, handMap);
            return result;
        }
        if (hand.length() == 0 || (hand.length() == 1 && !board.contains(hand))) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < hand.length(); i++) {
            String[] strings = checkIn(board, hand.charAt(i));
            for (String string : strings) {
                int result = dfs(string, hand.substring(0, i) + hand.substring(i + 1));
                if (result != -1) {
                    min = Math.min(min, result);
                }
            }
        }
        Map<String, Integer> handMap = MAP.getOrDefault(board, new HashMap<>());
        handMap.put(hand, min);
        MAP.put(board, handMap);
        return min;
    }

    private static String[] checkIn(String board, Character ch) {
        Set<String> result = new HashSet<>();
        StringBuilder sb = new StringBuilder(board);
        for (int i = 0; i < sb.length(); i++) {
            StringBuilder temp = new StringBuilder(board);
            temp.insert(i + 1, ch);
            process(temp);
            result.add(temp.toString());
        }
        return result.toArray(new String[0]);
    }

    private static void process(StringBuilder sb) {
        if (sb.length() < 3) {
            return;
        }
        char ch = sb.charAt(0);
        int count = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (count == 0) {
                ch = sb.charAt(i);
                count++;
            } else if (ch == sb.charAt(i)) {
                count++;
            } else {
                if (count >= 3) {
                    break;
                }
                ch = sb.charAt(i);
                count = 1;
            }
        }
        if (count <= 2) {
            return;
        }
        StringBuilder target = new StringBuilder();
        for (int i = 0; i < count; i++) {
            target.append(ch);
        }
        int start = sb.indexOf(target.toString());
        sb.delete(start, start + count);
        process(sb);
    }

    public static void main(String[] args) {
//        System.out.println(findMinStep("WRRBBW", "RB"));
//        System.out.println(findMinStep("WWRRBBWW", "WRBRW"));
//        System.out.println(findMinStep("G", "GGGGG"));
//        System.out.println(findMinStep("RBYYBBRRB", "YRBGB"));
//        System.out.println(findMinStep("WWRRBBWW", "WRBRW"));
//        System.out.println(findMinStep("WR",
//                "WWRR"));
        System.out.println(findMinStep("RRWWRRBBRR",
                "WB"));
    }
}
