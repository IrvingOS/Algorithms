package top.irvingsoft.exam.alibaba;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 阿里巴巴笔试第一题
 *
 * @author TimeChaser
 * @date 2021/3/12 18:59
 */
public class SolutionOne {

    private static HashMap<Integer, HashSet<Integer>> relationHashMap;

    public static void main(String[] args) {

        int n, m, q;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        relationHashMap = new HashMap<>(n);
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            if (relationHashMap.containsKey(a)) {
                HashSet<Integer> bHashSet = relationHashMap.get(a);
                bHashSet.add(b);
            } else {
                HashSet<Integer> bHashSet = new HashSet<>();
                bHashSet.add(b);
                relationHashMap.put(a, bHashSet);
            }
        }
        q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int count = 0;
            int x = in.nextInt();
            int y = in.nextInt();
            if (relationHashMap.containsKey(x)) {
                System.out.println(countRelation(count, y, relationHashMap.get(x)));
            } else {
                System.out.println("-1");
            }
        }
    }

    private static int countRelation(Integer count, Integer y, HashSet<Integer> yHashSet) {
        count++;
        if (yHashSet == null) {
            count = -1;
        } else if (!yHashSet.contains(y)) {
            boolean flag = true;
            for (Integer integer : yHashSet) {
                if (relationHashMap.containsKey(integer)) {
                    flag = false;
                    count = countRelation(count, y, relationHashMap.get(integer));
                }
            }
            if (flag) {
                count = -1;
            }
        }
        return count;
    }
}
