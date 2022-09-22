package top.irvingsoft.leetcode.code1640;

import java.util.HashMap;
import java.util.Map;

/*
 * 能否连接形成数组
 */
public class Solution {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            indexMap.put(arr[i], i);
        }
        for (int[] piece : pieces) {
            int i = piece[0];
            if (!indexMap.containsKey(i)) {
                return false;
            }
            int j = indexMap.get(i);
            for (int k = 1; k < piece.length; k++) {
                int curI = piece[k] ;
                if (!indexMap.containsKey(curI)) {
                    return false;
                }
                int curJ = indexMap.get(curI);
                if (curJ != j + 1) {
                    return false;
                }
                j = curJ;
            }
        }
        return true;
    }
}
