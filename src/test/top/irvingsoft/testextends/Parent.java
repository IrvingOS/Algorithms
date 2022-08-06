package top.irvingsoft.testextends;

import edu.princeton.cs.algs4.Counter;

/**
 * 父类
 *
 * @author TimeChaser
 * @since 2021/12/8 17:34
 */
public class Parent implements Comparable<Parent> {

    private Counter counter;

    public Parent(String id) {
        this.counter = new Counter(id);
    }

    public Parent(Counter counter) {
        this.counter = counter;
    }

    @Override
    public int compareTo(Parent o) {
        return this.counter.compareTo(o.counter);
    }

}
