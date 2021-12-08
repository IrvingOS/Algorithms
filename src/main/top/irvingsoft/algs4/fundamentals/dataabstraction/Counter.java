package top.irvingsoft.algs4.fundamentals.dataabstraction;

/**
 * 计数器
 *
 * @author TimeChaser
 * @since 2021/12/8 17:31
 */
public class Counter implements Comparable<Counter> {

    private final String name;
    private       int    count = 0;

    public Counter(String id) {
        name = id;
    }

    @Override
    public int compareTo(Counter o) {
        return Integer.compare(this.count, o.count);
    }

    public void increment() {
        count++;
    }

    public int tally() {
        return count;
    }

    @Override
    public String toString() {
        return count + " " + name;
    }
}
