package top.irvingsoft.leetcode.code207;

import java.io.IOException;
import java.util.*;

/**
 * @description: 课程表问题
 * @author: TimeChaser
 * @date: 2021/3/6 2:25
 */
public class Solution {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Set<Integer> sets[] = new HashSet[numCourses];
        int dCount[] = new int[numCourses];
        LinkedList<Integer> inProcess = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            dCount[i] = 0;
            sets[i] = new HashSet<>();
        }
        for (int[] prerequisite : prerequisites) {
            dCount[prerequisite[0]]++;
            sets[prerequisite[1]].add(prerequisite[0]);
        }
        /* 
        for (int i = 0; i < dCount.length; i++) {
                    if (dCount[i] == 0) {
                        inProcess.add(i);
                    }
                }
         */
 		int flag = 1;
        for (int i = 0; i < dCount.length; i++) {
            if (dCount[i] == 0) {
                flag = 0;
                inProcess.add(i);
            }
        }
        if (flag == 1) {
            return false;
        }

        int count = 0;
        while (!inProcess.isEmpty()) {
            Integer root = inProcess.pop();
            Iterator<Integer> iterator = sets[root].iterator();
            while (iterator.hasNext()) {
                Integer child = iterator.next();
                dCount[child]--;
                if (dCount[child] == 0) {
                    inProcess.add(child);
                }
            }
            count++;
        }

        return count == numCourses;
    }

    public static void main(String[] args) throws IOException {
/*        int numCourses = 2;
        int[][] ints = new int[1][2];
//        int[][] ints = new int[2][2];
        ints[0][0] = 1;
        ints[0][1] = 0;
//        ints[1][0] = 0;
//        ints[1][1] = 1;*/

        int numCourses = 8;
        int[][] ints = new int[6][2];
        ints[0][0] = 1;
        ints[0][1] = 0;
        ints[1][0] = 2;
        ints[1][1] = 6;
        ints[2][0] = 1;
        ints[2][1] = 7;
        ints[3][0] = 6;
        ints[3][1] = 4;
        ints[4][0] = 7;
        ints[4][1] = 0;
        ints[5][0] = 0;
        ints[5][1] = 5;



        System.out.println(canFinish(numCourses, ints));
    }
}
/**
 * 8
 * [[1,0],[2,6],[1,7],[6,4],[7,0],[0,5]]
 */
