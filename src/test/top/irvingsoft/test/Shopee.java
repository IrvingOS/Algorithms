package top.irvingsoft.test;

import java.util.*;

/**
 * Shopee
 *
 * @author TimeChaser
 * @since 2022/3/14 7:48 PM
 */
public class Shopee {

    private int result;

    public static void main(String[] args) {
        System.out.println(new Shopee().findMaximizedCapitalPQ(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}));
    }

    public int findMaximizedCapitalDFS(int k, int w, int[] profits, int[] capital) {
        result = w;
        int[][] project = new int[profits.length][2];
        for (int i = 0; i < profits.length; i++) {
            project[i][0] = capital[i];
            project[i][1] = profits[i];
        }
        Arrays.sort(project, Comparator.comparingInt(a -> a[0]));
        new PriorityQueue<Integer>(Comparator.comparingInt(x -> -x));
        dfs(k, w, w, project, new boolean[capital.length]);
        return result;
    }

    public int findMaximizedCapitalPQ(int k, int w, int[] profits, int[] capital) {
        // write code here
        int n = profits.length;
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> ((b[1] - b[0]) - (a[1] - a[0])));
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{capital[i], profits[i]});
        }
        Iterator<int[]> iterator = pq.iterator();
        while (iterator.hasNext()) {
            System.out.println(Arrays.toString(iterator.next()));
        }
        int result = 0;
        List<int[]> overs = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            while (!pq.isEmpty() && pq.peek()[0] > w) {
                System.out.println(Arrays.toString(pq.peek()));
                overs.add(pq.poll());
            }
            if (pq.isEmpty()) {
                break;
            }
            int[] project = pq.poll();
            while (!pq.isEmpty() && pq.peek()[1] - pq.peek()[0] == project[1] - project[0] &&
                   pq.peek()[0] < project[0]) {
                overs.add(project);
                project = pq.poll();
            }
            w += project[1] - project[0];
            result += project[1];
            for (int[] over : overs) {
                System.out.println(Arrays.toString(over));
            }
            pq.addAll(overs);
            overs.clear();
        }
        return result;
    }

    private void buildZeros(int[] zeros, int[] nums) {
        int n = nums.length;
        int i = 0, j = 0;
        boolean left = false;
        while (j < n && nums[j] == 0) {
            j++;
        }
        for (int count = 0; j < n; j++) {
            if (nums[j] == 1) {
                left = !left;
            } else {
                count++;
            }
            if (!left) {
                zeros[i++] = count;
                count = 0;
            }
        }
    }

    private void dfs(int k, int w, int count, int[][] project, boolean[] visited) {
        if (k == 0) {
            result = Math.max(count, result);
            return;
        }
        for (int i = 0; i < project.length; i++) {
            if (visited[i] || project[i][0] > w) {
                continue;
            }
            visited[i] = true;
            dfs(k - 1, w + project[i][1] - project[i][0], count + project[i][1], project, visited);
            visited[i] = false;
        }
        result = Math.max(count, result);
    }

}
