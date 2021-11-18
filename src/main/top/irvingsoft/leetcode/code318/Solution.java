package top.irvingsoft.leetcode.code318;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 最大单词长度乘积
 * <p>
 * 位掩码
 *
 * @author TimeChaser
 * @since 2021/11/17 15:00
 */
public class Solution {

    public int maxProduct(String[] words) {
        Map<Integer, Integer> bitMaskLengthMap = new HashMap<>();
        for (String word : words) {
            int bitMask = getBitMask(word);
            if (word.length() > bitMaskLengthMap.getOrDefault(bitMask, 0)) {
                bitMaskLengthMap.put(bitMask, word.length());
            }
        }
        int result = 0;
        Set<Integer> bitMaskSet = bitMaskLengthMap.keySet();
        for (Integer bitMask1 : bitMaskSet) {
            for (Integer bitMask2 : bitMaskSet) {
                if ((bitMask1 & bitMask2) == 0) {
                    result = Math.max(result, bitMaskLengthMap.get(bitMask1) * bitMaskLengthMap.get(bitMask2));
                }
            }
        }
        return result;
    }

    private int getBitMask(String word) {
        int mask = 0;
        for (int i = 0; i < word.length(); i++) {
            mask |= 1 << (word.charAt(i) - 'a');
        }
        return mask;
    }
}
