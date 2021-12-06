package top.irvingsoft.algs4.sorting.priorityqueues;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;

/**
 * @author TimeChaser
 * @since 2021/12/1 15:54
 */
public class MinPQTest {

    public static void main(String[] args) {
        Random random = new Random();
        MinPQ<User> pq = new MinPQ<>(Comparator.comparing(o -> o.id));
        pq.insert(new User(random.nextInt(100), "qqq"));
        pq.insert(new User(random.nextInt(100), "www"));
        pq.insert(new User(random.nextInt(100), "eee"));
        pq.insert(new User(random.nextInt(100), "rrr"));
        pq.insert(new User(random.nextInt(100), "ttt"));
        Iterator<User> iterator = pq.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    static class User {
        int    id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}