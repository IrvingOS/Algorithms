package top.irvingsoft.algs4.searching.symboltables;

/**
 * @author TimeChaser
 * @since 2021/11/29 21:53
 */
public class OrderedSequentialSearchSTTest {

    public static void main(String[] args) {
        OrderedSequentialSearchST<Integer, String> st = new OrderedSequentialSearchST<>();
        st.put(3, "three");
        st.put(1, "test");
        st.put(2, "two");
        st.put(0, "zero");
        st.put(4, "four");
        st.put(5, "five");
        System.out.println(st.keys());
    }

}