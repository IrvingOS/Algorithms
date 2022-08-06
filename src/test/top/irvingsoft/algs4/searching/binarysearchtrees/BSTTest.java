package top.irvingsoft.algs4.searching.binarysearchtrees;

/**
 * @author TimeChaser
 * @since 2021/11/18 15:42
 */
public class BSTTest {

    public static void main(String[] args) {
        BSTRecursion<Integer, String> bstRecursion = new BSTRecursion<>();
        bstRecursion.put(3, "three");
        bstRecursion.put(1, "test");
        bstRecursion.put(2, "two");
        bstRecursion.put(0, "zero");
        bstRecursion.put(4, "four");
        bstRecursion.put(5, "five");
        Iterable<Integer> keysRecursion = bstRecursion.keys();
        int i = 0;
        for (Integer key : keysRecursion) {
            assert bstRecursion.rank(bstRecursion.select(i)) == i &&
                   key.equals(bstRecursion.select(bstRecursion.rank(key)));
            i++;
        }
        BSTIteration<Integer, String> bstIteration = new BSTIteration<>();
        bstIteration.put(1, "test");
        bstIteration.put(2, "two");
        bstIteration.put(3, "three");
        bstIteration.put(0, "zero");
        bstIteration.put(4, "four");
        bstIteration.put(5, "five");
        Iterable<Integer> keysIteration = bstRecursion.keys();
        i = 0;
        for (Integer key : keysIteration) {
            assert bstIteration.rank(bstIteration.select(i)) == i &&
                   key.equals(bstIteration.select(bstIteration.rank(key)));
            i++;
        }
    }

}
