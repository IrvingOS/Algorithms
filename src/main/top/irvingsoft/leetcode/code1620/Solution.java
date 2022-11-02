package top.irvingsoft.leetcode.code1620;

/*
 * 网络信号最好的坐标
 */
public class Solution {

    public int[] bestCoordinate(int[][] towers, int radius) {
        if(towers.length == 1) {
            return towers[0][2] == 0 ? new int[]{0, 0} : new int[] {towers[0][0], towers[0][1]};
        }
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
        for (int[] tower : towers) {
            minX = Math.min(minX, tower[0]);
            minY = Math.min(minY, tower[1]);
            maxX = Math.max(maxX, tower[0]);
            maxY = Math.max(maxY, tower[1]);
        }
        int max = 0;
        int[] result = new int[2];
        for(int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                int cur = getEnerge(towers, i, j, radius);
                if (cur > max ) {
                    result[0] = i;
                    result[1] = j;
                    max = cur;
                }
            }
        }
        return result;
    }

    private int getEnerge(int[][] towers, int i, int j, int radius) {
        int sum = 0;
        for (int[] tower : towers) {
            double distance = getDistance(tower, i, j);
            if(distance <= radius) {
                sum += tower[2] / (1 + distance);
            }
        }
        return sum;
    }

    private double getDistance(int[] tower, int i, int j) {
        int x = Math.abs(tower[0] - i);
        int y = Math.abs(tower[1] - j);
        return Math.sqrt(x * x + y * y);
    }

    public static void main(String[] args) {
        int[] tower = new int[]{42, 0 ,0};
        int[][] towers = new int[][]{tower};
        Solution solution = new Solution();

        solution.bestCoordinate(towers, 7);
    }
}
