package top.irvingsoft.test;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author TimeChaser
 * @since 2021/11/28 11:16
 */
@SuppressWarnings("all")
public class TestTest {

    public static void main(String[] args) {
        System.out.println(testAssignmentAndReturn());
    }

    public static int testAssignmentAndReturn() {
        int a = 1;
        int b = 2;
        return a > b ? a : (a = b);
    }

    public static void testQueue() {
        Queue<Integer> queue = new ArrayDeque<>();

    }

    public static void testListToArray() {
        List<Integer> list = new ArrayList<>();
        int[] ints = list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void testArrayToList() {
        int[] ints = new int[0];
        List<Integer> collect = Arrays.stream(ints).boxed().collect(Collectors.toList());
    }

    public static void testListReverse() {
        List<Integer> list = new ArrayList<>();
        Collections.reverse(list);
    }

    @Test
    public void testCompareTo() {
        Integer i1 = 1;
        Integer i2 = 5;
        System.out.println(i1.compareTo(i2));
        System.out.println(i1 - i2);
        String s1 = "sss";
        String s2 = "ttt";
        System.out.println(s1.compareTo(s2));
//        System.out.println(s1 - s2);
    }

    @Test
    public void testComputeAndPrint() {
        System.out.println('b');
        System.out.println('b' + 'c');
        System.out.println((char) ('a' + 4));
        System.out.println(1.0 / 0.0);
        System.out.println(1.0 / 0);
        System.out.println(1 / 0.0);
        System.out.println(1.0 / 0.0 == 1.0 / 0 && 1.0 / 0 == 1 / 0.0);
        System.out.println(3 / 1 == 3 / 1.0);
        System.out.println(1 == 1.0);
//        System.out.println(1 / 0);
    }

    @Test
    public void testAbs() {
        System.out.println(Math.abs(Integer.MIN_VALUE));
        System.out.println(Math.abs((long) Integer.MIN_VALUE));
    }

    public long maxRunTime(int n, int[] batteries) {
        if(batteries.length < n) {
            return 0;
        }
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for(int battery : batteries) {
            pq.offer(battery);
        }
        long count = 0;
        while(true) {
            if(pq.size() < n) {
                break;
            }
            List<Integer> curBatteries = new ArrayList<>();
            int minBattery = Integer.MAX_VALUE;
            for(int i = 0; i < n; i++) {
                curBatteries.add(pq.poll());
            }
            List<Integer> temp = new ArrayList<>();
            while(!pq.isEmpty()) {
                int poll = pq.poll();
                minBattery = Math.min(poll, minBattery);
                temp.add(poll);
            }
            for(Integer battery : temp) {
                pq.offer(battery);
            }
            int less = minBattery != Integer.MAX_VALUE && minBattery > 1 ? minBattery - 1 : 1;
            for(Integer battery : curBatteries) {
                if(battery - less > 0) {
                    pq.offer(battery - less);
                }
            }
            count += less;
        }
        return count;
    }
}
