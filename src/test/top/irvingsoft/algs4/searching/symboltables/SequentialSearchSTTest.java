package top.irvingsoft.algs4.searching.symboltables;

/**
 * @author TimeChaser
 * @since 2021/11/29 16:09
 */
public class SequentialSearchSTTest {

    public static void main(String[] args) {
        SequentialSearchST<Integer, String> st = new SequentialSearchST<>();
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
    }
}
