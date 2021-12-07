package top.irvingsoft.test;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author TimeChaser
 * @since 2021/11/28 11:16
 */
public class test {

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
    }

}
