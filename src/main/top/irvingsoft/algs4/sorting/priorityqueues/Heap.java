package top.irvingsoft.algs4.sorting.priorityqueues;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 堆排序
 *
 * @author TimeChaser
 * @since 2021/12/6 21:32
 */
public class Heap {

    private Heap() {
    }

    public static void sort(Comparable[] pq) {
        int n = pq.length;

        // heapify phase
        for (int k = n / 2; k >= 1; k--) {
            sink(pq, k, n);
        }

        // sort down phase
        int k = n;
        while (k > 1) {
            exchange(pq, 1, k--);
            sink(pq, 1, k);
        }
    }

    private static void sink(Comparable[] pq, int k, int n) {
        while (k * 2 <= n) {
            int j = k * 2;
            if (j < n && less(pq, j + 1, j)) {
                j++;
            }
            if (!less(pq, j, k)) {
                break;
            }
            exchange(pq, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i - 1].compareTo(pq[j - 1]) > 0;
    }

    private static void exchange(Object[] pq, int i, int j) {
        Object temp = pq[i - 1];
        pq[i - 1] = pq[j - 1];
        pq[j - 1] = temp;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        Heap.sort(a);
        show(a);
    }
}
