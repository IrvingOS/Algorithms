package top.irvingsoft.algs4.sorting.priorityqueues;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;

public class IndexMaxPQTest {

    public static void merge(In[] streams) {
        int n = streams.length;
        IndexMaxPQ<String> pq = new IndexMaxPQ<>(n);

        for (int i = 0; i < n; i++) {
            if (!streams[i].isEmpty()) {
                pq.insert(i, streams[i].readString());
            }
        }
        for (Integer integer : pq) {
            StdOut.println(integer);
        }
        while (!pq.isEmpty()) {
            StdOut.println(pq.maxKey());
            int i = pq.delMax();

            if (!streams[i].isEmpty()) {
                pq.insert(i, streams[i].readString());
            }
        }
    }

    @Test
    public void testIterator() {
        String[] args = new String[3];
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

}