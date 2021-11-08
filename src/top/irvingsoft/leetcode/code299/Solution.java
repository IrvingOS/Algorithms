package top.irvingsoft.leetcode.code299;

import java.util.HashMap;
import java.util.Map;

/**
 * 猜数字游戏
 *
 * @author TimeChaser
 * @since 2021/11/8 8:24
 */
public class Solution {

    public static String getHintHash(String secret, String guess) {
        int n = secret.length();
        int countA = 0;
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapG = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                countA++;
            } else {
                mapS.put(secret.charAt(i), mapS.getOrDefault(secret.charAt(i), 0) + 1);
                mapG.put(guess.charAt(i), mapG.getOrDefault(guess.charAt(i), 0) + 1);
            }
        }
        int countB = 0;
        for (Map.Entry<Character, Integer> entryS : mapS.entrySet()) {
            if (mapG.containsKey(entryS.getKey())) {
                countB += Math.min(entryS.getValue(), mapG.get(entryS.getKey()));
            }
        }
        return countA + "A" + countB + "B";
    }

    public static String getHintArray(String secret, String guess) {
        int bulls = 0;
        int[] cntS = new int[10];
        int[] cntG = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                cntS[secret.charAt(i) - '0']++;
                cntG[guess.charAt(i) - '0']++;
            }
        }
        int cows = 0;
        for (int i = 0; i < 10; i++) {
            cows += Math.min(cntS[i], cntG[i]);
        }
        return bulls + "A" + cows + "B";
    }


    public static void main(String[] args) {
        System.out.println(getHintHash("1807", "7810"));
        System.out.println(getHintHash("1123", "0111"));
        System.out.println(getHintHash("1", "0"));
        System.out.println(getHintHash("1", "1"));
    }
}
