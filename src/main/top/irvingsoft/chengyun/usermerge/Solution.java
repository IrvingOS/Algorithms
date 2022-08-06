package top.irvingsoft.chengyun.usermerge;

import top.irvingsoft.chengyun.unionfind.UnionSet;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 用并查集合并用户
 *
 * @author TimeChaser
 * @since 2021/8/8 10:25
 */
public class Solution {

    public static int mergeUsers(User[] users) {

        UnionSet<User> userUnionSet = new UnionSet<>(Arrays.asList(users));
        HashMap<String, User> mapA = new HashMap<>();
        HashMap<String, User> mapB = new HashMap<>();
        HashMap<String, User> mapC = new HashMap<>();

        for (User user : users) {

            if (mapA.containsKey(user.a)) {
                userUnionSet.union(user, mapA.get(user.a));
            } else {
                mapA.put(user.a, user);
            }
            if (mapB.containsKey(user.b)) {
                userUnionSet.union(user, mapB.get(user.b));
            } else {
                mapB.put(user.b, user);
            }
            if (mapC.containsKey(user.c)) {
                userUnionSet.union(user, mapC.get(user.c));
            } else {
                mapC.put(user.c, user);
            }
        }

        return userUnionSet.getSize();
    }

    public static class User {

        public String a;
        public String b;
        public String c;

        public User(String a, String b, String c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

    }

}
