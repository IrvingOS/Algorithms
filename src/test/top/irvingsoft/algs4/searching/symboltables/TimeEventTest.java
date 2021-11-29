package top.irvingsoft.algs4.searching.symboltables;

/**
 * @author TimeChaser
 * @since 2021/11/29 23:34
 */
public class TimeEventTest {

    public static void main(String[] args) {
        BinarySearchST<Time, Event> st = new BinarySearchST<>();
        st.put(new Time("09:00:00"), new Event("Chicago"));
        st.put(new Time("09:00:03"), new Event("Phoenix"));
        st.put(new Time("09:00:13"), new Event("Houston"));
        st.put(new Time("09:00:59"), new Event("Chicago"));
        st.put(new Time("09:01:10"), new Event("Houston"));
        st.put(new Time("09:03:13"), new Event("Chicago"));
        st.put(new Time("09:10:11"), new Event("Seattle"));
        st.put(new Time("09:10:25"), new Event("Seattle"));
        st.put(new Time("09:14:25"), new Event("Phoenix"));
        st.put(new Time("09:19:32"), new Event("Chicago"));
        st.put(new Time("09:19:46"), new Event("Chicago"));
        st.put(new Time("09:21:05"), new Event("Chicago"));
        st.put(new Time("09:22:43"), new Event("Seattle"));
        st.put(new Time("09:22:54"), new Event("Seattle"));
        st.put(new Time("09:25:52"), new Event("Chicago"));
        st.put(new Time("09:35:21"), new Event("Chicago"));
        st.put(new Time("09:36:14"), new Event("Seattle"));
        st.put(new Time("09:37:44"), new Event("Phoenix"));
        System.out.println(st.min());
        System.out.println(st.max());
        System.out.println(st.keys());
    }
}
