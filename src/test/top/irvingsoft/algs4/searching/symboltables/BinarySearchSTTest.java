package top.irvingsoft.algs4.searching.symboltables;

/**
 * @author TimeChaser
 * @since 2021/11/29 17:31
 */
public class BinarySearchSTTest {

    public static void main(String[] args) {
        BinarySearchST<Integer, String> st = new BinarySearchST<>(1);
        st.put(3, "three");
        st.put(1, "test");
        st.put(2, "two");
        st.put(0, "zero");
        st.put(4, "four");
        st.put(5, "five");
        Iterable<Integer> keys = st.keys();
        int i = 0;
        for (Integer key : keys) {
            assert st.rank(st.select(i)) == i && key.equals(st.select(st.rank(key)));
            i++;
        }
        st.delete(1);
        st.delete(5);
        st.delete(3);
        i = 0;
        for (Integer key : keys) {
            assert st.rank(st.select(i)) == i && key.equals(st.select(st.rank(key)));
            i++;
        }
    }
}
