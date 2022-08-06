package top.irvingsoft.leetcode.code89;

import java.util.ArrayList;
import java.util.List;

/**
 * 格雷编码
 *
 * @author TimeChaser
 * @since 2021/11/13 9:28
 */
public class Solution {

    public static List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = result.size() - 1; j >= 0; j--) {
                result.add(head + result.get(j));
            }
            head <<= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(grayCode(4));
    }

}
