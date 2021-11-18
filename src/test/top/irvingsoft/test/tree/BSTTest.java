package top.irvingsoft.test.tree;

import top.irvingsoft.code.tree.BST;

/**
 * @author TimeChaser
 * @since 2021/11/18 15:42
 */
public class BSTTest {

    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<>();
        bst.put(1, "test");
        bst.put(2, "two");
        bst.put(3, "three");
        bst.put(0, "zero");
        bst.put(4, "four");
        bst.put(5, "five");

        bst.put(1, "one");
        System.out.println(bst.get(1));
        System.out.println(bst.min());
        System.out.println(bst.max());
        System.out.println(bst.select(1));
        System.out.println(bst.floor(2));
        System.out.println(bst.ceiling(2));
        System.out.println(bst.select(2));
        System.out.println(bst.rank(3));

        bst.delete(3);
        Iterable<Integer> keys = bst.keys(1, 4);
        System.out.println(keys);
    }
}
