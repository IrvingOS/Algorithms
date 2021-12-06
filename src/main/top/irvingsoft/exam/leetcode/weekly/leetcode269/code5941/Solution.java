package top.irvingsoft.exam.leetcode.weekly.leetcode269.code5941;

import java.util.*;

/**
 * 找出知晓秘密的所有专家
 * <p>
 * 1. 优先级队列
 * <p>
 * 2. 并查集
 *
 * @author TimeChaser
 * @since 2021/11/28 15:01
 */
public class Solution {

    public List<Integer> findAllPeoplePriorityQueue(int n, int[][] meetings, int firstPerson) {
        List<int[]>[] lists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] meeting : meetings) {
            lists[meeting[0]].add(new int[]{meeting[1], meeting[2]});
            lists[meeting[1]].add(new int[]{meeting[0], meeting[2]});
        }
        List<Integer> result = new ArrayList<>();
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        queue.add(new int[2]);
        queue.add(new int[]{firstPerson, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            List<int[]> list = lists[poll[0]];
            if (list != null) {
                result.add(poll[0]);
                for (int[] ints : list) {
                    if (ints[1] >= poll[1]) {
                        queue.offer(ints);
                    }
                }
                lists[poll[0]] = null;
            }
        }
        return result;
    }

    public List<Integer> findAllPeopleUnionFind(int n, int[][] meetings, int firstPerson) {
        int len = meetings.length;
        Arrays.sort(meetings, Comparator.comparingInt(o -> o[2]));
        UnionFind unionFind = new UnionFind(n);
        unionFind.merge(0, firstPerson);

        for (int i = 0; i < len; i++) {
            int[] meeting = meetings[i];
            int times = meeting[2];
            Set<Integer> persons = new HashSet<>();
            while (true) {
                persons.add(meeting[0]);
                persons.add(meeting[1]);

                if (unionFind.find(meeting[0]) == unionFind.find(0)) {
                    unionFind.merge(meeting[0], meeting[1]);
                } else if (unionFind.find(meeting[1]) == unionFind.find(0)) {
                    unionFind.merge(meeting[1], meeting[0]);
                } else {
                    unionFind.merge(meeting[0], meeting[1]);
                }
                if (i + 1 < len && meetings[i + 1][2] == times) {
                    i++;
                } else {
                    break;
                }
            }
            for (Integer person : persons) {
                if (unionFind.find(person) != unionFind.find(0)) {
                    unionFind.split(person);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (unionFind.find(i) == unionFind.find(0)) {
                result.add(i);
            }
        }
        return result;
    }

    class UnionFind {
        public int[] father;

        public UnionFind(int len) {
            father = new int[len];
            for (int i = 0; i < len; i++) {
                father[i] = i;
            }
        }

        public int find(int x) {
            if (x < 0 || x > father.length - 1) {
                return -1;
            }
            return x == father[x] ? x : (father[x] = find(father[x]));
        }

        public void merge(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            father[yRoot] = xRoot;
        }

        public void split(int x) {
            father[x] = x;
        }
    }
}
