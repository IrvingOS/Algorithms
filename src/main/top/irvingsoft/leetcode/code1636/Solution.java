package top.irvingsoft.leetcode.code1636;

import java.util.*;

/**
 * 按照频率将数组升序排序
 *
 * @author TimeChaser
 * @since 19/9/2022 上午7:04
 */
public class Solution {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            list.add(num);
        }
        list.sort((o1, o2) -> {
            int cnt1 = map.get(o1);
            int cnt2 = map.get(o2);
            return cnt1 != cnt2 ? cnt1 - cnt2 : o2 - o1;
        });
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

    public int[] mine(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> !Objects.equals(o1.getValue(), o2.getValue()) ? o1.getValue().compareTo(o2.getValue()) :
                              o2.getKey().compareTo(o1.getKey()));
        for (int i = 0, e = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).getValue(); j++) {
                nums[e++] = list.get(i).getKey();
            }
        }
        return nums;
    }

}
