package top.irvingsoft.algs4.sorting.priorityqueues;

import java.util.Random;

public class MaxPQTest {

    public static void main(String[] args) {
        Random random = new Random();
//        MaxPQ<User> pq = new MaxPQ<>(Comparator.comparing(o -> o.id));
        MaxPQ<User> pq = new MaxPQ<>();
        pq.insert(new User(random.nextInt(100), "qqq"));
        pq.insert(new User(random.nextInt(100), "www"));
        pq.insert(new User(random.nextInt(100), "eee"));
        pq.insert(new User(random.nextInt(100), "rrr"));
        pq.insert(new User(random.nextInt(100), "ttt"));
        for (User user : pq) {
            System.out.println(user);
        }
    }

    static class User implements Comparable<User> {
        int    id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public int compareTo(User o) {
            return id - o.id;
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