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

    public static void main(String[] args) {
        //        System.out.println(findMinStep("WRRBBW", "RB"));
        //        System.out.println(findMinStep("WWRRBBWW", "WRBRW"));
        //        System.out.println(findMinStep("G", "GGGGG"));
        //        System.out.println(findMinStep("RBYYBBRRB", "YRBGB"));
        //        System.out.println(findMinStep("WWRRBBWW", "WRBRW"));
        //        System.out.println(findMinStep("WR",
        //                "WWRR"));
        System.out.println(findMinStep("RRWWRRBBRR", "WB"));
    }

    /**
     * 向 board 中每个字符后依次插入字符并处理
     *
     * @param board board
     * @param ch    插入的字符
     * @return java.lang.String[]
     */
    private static String[] checkIn(String board, Character ch) {
        Set<String> result = new HashSet<>();
        StringBuilder sb = new StringBuilder(board);
        for (int i = 0; i < sb.length(); i++) {
            StringBuilder temp = new StringBuilder(board);
            temp.insert(i + 1, ch);
            process(temp);
            // 将插入并处理后的字符串加入结果集
            result.add(temp.toString());
        }
        return result.toArray(new String[0]);
    }

    private static int dfs(String board, String hand) {
        if (MAP.containsKey(board)) {
            if (MAP.get(board).containsKey(hand)) {
                // 缓存查询
                return MAP.get(board).get(hand);
            }
        }
        if (board.length() == 0) {
            int result = originalLength - hand.length();
            // 加入缓存
            Map<String, Integer> handMap = MAP.getOrDefault(board, new HashMap<>());
            handMap.put(hand, result);
            MAP.put(board, handMap);
            return result;
        }
        if (hand.length() == 0 || (hand.length() == 1 && !board.contains(hand))) {
            // hand 长度为 0，或者长度为 1 但不存在于 board 中
            return -1;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < hand.length(); i++) {
            String[] strings = checkIn(board, hand.charAt(i));
            for (String string : strings) {
                // 遍历插入并处理后的结果集，递归进行下一步处理
                int result = dfs(string, hand.substring(0, i) + hand.substring(i + 1));
                // 收集最小值，-1 在主方法里处理
                min = result != -1 ? Math.min(min, result) : min;
            }
        }
        // 结果加入缓存
        Map<String, Integer> handMap = MAP.getOrDefault(board, new HashMap<>());
        handMap.put(hand, min);
        MAP.put(board, handMap);
        return min;
    }

    /**
     * 递归消去 3 个及以上的连续字符
     *
     * @param sb StringBuilder
     */
    private static void process(StringBuilder sb) {
        if (sb.length() < 3) {
            // 字符串长度不足
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
            // 不存在连续的三个字符
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

}
