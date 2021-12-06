package top.irvingsoft.algs4.sorting.priorityqueues;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author TimeChaser
 * @since 2021/11/30 20:53
 */
public class IndexMinPQTest {

    public static void main(String[] args) {
        args = new String[3];
        args[0] = "C:\\Users\\Administrator\\Desktop\\算法第四版文件\\algs4-data\\m1.txt";
        args[1] = "C:\\Users\\Administrator\\Desktop\\算法第四版文件\\algs4-data\\m2.txt";
        args[2] = "C:\\Users\\Administrator\\Desktop\\算法第四版文件\\algs4-data\\m3.txt";
        int n = args.length;
        In[] streams = new In[n];
        for (int i = 0; i < n; i++) {
            streams[i] = new In(args[i]);
        }
        merge(streams);
    }

    public static void merge(In[] streams) {
        int n = streams.length;
        IndexMinPQ<String> pq = new IndexMinPQ<>(n);

        for (int i = 0; i < n; i++) {
            if (!streams[i].isEmpty()) {
                pq.insert(i, streams[i].readString());
            }
        }
        for (Integer integer : pq) {
            StdOut.println(integer);
        }
        while (!pq.isEmpty()) {
            StdOut.println(pq.minKey());
            int i = pq.delMin();

            if (!streams[i].isEmpty()) {
                pq.insert(i, streams[i].readString());
            }
        }
    }
}