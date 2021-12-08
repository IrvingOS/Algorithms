package top.irvingsoft.testextents;

import edu.princeton.cs.algs4.Counter;

/**
 * 子类
 *
 * @author TimeChaser
 * @since 2021/12/8 17:34
 */
public class Child extends Parent {

    public Child(String id) {
        super(id);
    }

    public Child(Counter counter) {
        super(counter);
    }
}
