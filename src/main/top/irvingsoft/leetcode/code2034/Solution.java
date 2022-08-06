package top.irvingsoft.leetcode.code2034;

import java.util.*;

/**
 * 股票价格波动
 *
 * @author TimeChaser
 * @since 2022/1/23 11:54
 */
public class Solution {

}

class StockPrice {

    private final Map<Integer, Integer> map;
    private final Queue<int[]> maxQueue;
    private final Queue<int[]> minQueue;
    private int curTimestamp;

    public StockPrice() {
        map = new HashMap<>();
        maxQueue = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        minQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
    }

    public int current() {
        return map.get(curTimestamp);
    }

    public int maximum() {
        while (true) {
            int[] max = maxQueue.poll();
            int timestamp = max[0];
            int price = max[1];
            if (map.get(timestamp) == price) {
                maxQueue.offer(max);
                return price;
            }
        }
    }

    public int minimum() {
        while (true) {
            int[] min = minQueue.poll();
            int timestamp = min[0];
            int price = min[1];
            if (map.get(timestamp) == price) {
                minQueue.offer(min);
                return price;
            }
        }
    }

    public void update(int timestamp, int price) {
        curTimestamp = Math.max(curTimestamp, timestamp);
        map.put(timestamp, price);
        maxQueue.offer(new int[]{timestamp, price});
        minQueue.offer(new int[]{timestamp, price});
    }

}

