package top.irvingsoft.leetcode.code911;

import java.util.TreeMap;

/**
 * 在线选举
 *
 * @author TimeChaser
 * @since 2021/12/11 12:36
 */
public class Solution {
}

/**
 * 利用 TreeMap 的 floorEntry 方法
 * <p>
 * 注意：
 * vote.floorEntry(t).getValue(); 比 vote.get(vote.floorKey(t)); 更快
 */
class TopVotedCandidateTreeMap {

    private final TreeMap<Integer, Integer> vote;

    public TopVotedCandidateTreeMap(int[] persons, int[] times) {
        int n = persons.length;
        int[] personCount = new int[n];
        vote = new TreeMap<>();
        int candidate = 0;
        for (int i = 0; i < n; i++) {
            personCount[persons[i]]++;
            candidate = personCount[persons[i]] >= personCount[candidate] ? persons[i] : candidate;
            vote.put(times[i], candidate);
        }
    }

    public int q(int t) {
        vote.get(vote.floorKey(t));
        return vote.floorEntry(t).getValue();
    }
}

/**
 * 数组 + 二分查找
 */
class TopVotedCandidateBinarySearch {

    private final int[] times;
    private final int[] candidates;

    public TopVotedCandidateBinarySearch(int[] persons, int[] times) {
        int n = persons.length;
        this.times = times;
        this.candidates = new int[n];
        int[] personCount = new int[n];
        int candidate = 0;
        for (int i = 0; i < n; i++) {
            personCount[persons[i]]++;
            candidate = personCount[persons[i]] >= personCount[candidate] ? persons[i] : candidate;
            candidates[i] = candidate;
        }
    }

    public int q(int t) {
        int lo = 0;
        int hi = times.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (t < times[mid]) {
                hi = mid - 1;
            } else if (t > times[mid]) {
                lo = mid + 1;
            } else {
                return candidates[mid];
            }
        }
        return candidates[lo - 1];
    }
}
