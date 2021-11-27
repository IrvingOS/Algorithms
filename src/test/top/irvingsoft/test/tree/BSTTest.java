package top.irvingsoft.test.tree;

import top.irvingsoft.code.tree.BSTIteration;
import top.irvingsoft.code.tree.BSTRecursion;

/**
 * @author TimeChaser
 * @since 2021/11/18 15:42
 */
public class BSTTest {

    public static void main(String[] args) {
        BSTRecursion<Integer, String> bstRecursion = new BSTRecursion<>();
        bstRecursion.put(1, "test");
        bstRecursion.put(2, "two");
        bstRecursion.put(3, "three");
        bstRecursion.put(0, "zero");
        bstRecursion.put(4, "four");
        bstRecursion.put(5, "five");
        BSTIteration<Integer, String> bstIteration = new BSTIteration<>();
        bstIteration.put(1, "test");
        bstIteration.put(2, "two");
        bstIteration.put(3, "three");
        bstIteration.put(0, "zero");
        bstIteration.put(4, "four");
        bstIteration.put(5, "five");

        System.out.println(bstIteration.keys(4, 5));
    }
}
