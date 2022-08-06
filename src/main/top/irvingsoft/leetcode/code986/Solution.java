package top.irvingsoft.leetcode.code986;

import java.util.ArrayList;
import java.util.List;

/**
 * 区间列表的交集
 *
 * @author TimeChaser
 * @since 2021/11/22 22:49
 */
public class Solution {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> intervalList = new ArrayList<>();
        int indexFirst = 0;
        int indexSecond = 0;
        while (indexFirst < firstList.length && indexSecond < secondList.length) {
            while (indexSecond < secondList.length && firstList[indexFirst][0] > secondList[indexSecond][1]) {
                indexSecond++;
            }
            if (indexSecond == secondList.length) {
                break;
            }
            while (indexFirst < firstList.length && firstList[indexFirst][1] < secondList[indexSecond][0]) {
                indexFirst++;
            }
            if (indexFirst == firstList.length) {
                break;
            }
            if (firstList[indexFirst][0] > secondList[indexSecond][0]) {
                if (firstList[indexFirst][1] < secondList[indexSecond][1]) {
                    intervalList.add(firstList[indexFirst]);
                    indexFirst++;
                } else {
                    if (firstList[indexFirst][0] <= secondList[indexSecond][1]) {
                        intervalList.add(new int[]{firstList[indexFirst][0], secondList[indexSecond][1]});
                    }
                    indexSecond++;
                }
            } else {
                if (firstList[indexFirst][1] < secondList[indexSecond][1]) {
                    if (secondList[indexSecond][0] <= firstList[indexFirst][1]) {
                        intervalList.add(new int[]{secondList[indexSecond][0], firstList[indexFirst][1]});
                    }
                    indexFirst++;
                } else {
                    intervalList.add(secondList[indexSecond]);
                    indexSecond++;
                }
            }
        }
        return intervalList.toArray(new int[intervalList.size()][]);
    }

    public int[][] intervalIntersectionMerge(int[][] A, int[][] B) {
        List<int[]> ans = new ArrayList<>();
        int i = 0, j = 0;

        while (i < A.length && j < B.length) {
            // Let's check if A[i] intersects B[j].
            // lo - the start point of the intersection
            // hi - the end point of the intersection
            int lo = Math.max(A[i][0], B[j][0]);
            int hi = Math.min(A[i][1], B[j][1]);
            if (lo <= hi) {
                ans.add(new int[]{lo, hi});
            }
            // Remove the interval with the smallest endpoint
            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }

}
