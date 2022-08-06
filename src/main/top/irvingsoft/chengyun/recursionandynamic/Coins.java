package top.irvingsoft.chengyun.recursionandynamic;

/**
 * Page 214
 *
 * @author TimeChaser
 * @since 2021/9/25 21:56
 */
public class Coins {

    public static int coins1(int[] arr, int aim) {

        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process1(arr, 0, aim);
    }

    public static int coins2(int[] arr, int aim) {

        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] map = new int[arr.length + 1][aim + 1];
        return process2(arr, 0, aim, map);
    }

    public static int coins3(int[] arr, int aim) {

        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }

        int[][] dp = new int[arr.length][aim + 1];
        // 组成 0 元的方法有 1 种
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; arr[0] * j <= aim; j++) {
            dp[0][arr[0] * j] = 1;
        }
        int num;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                num = 0;
                for (int k = 0; j - arr[i] * k >= 0; k++) {
                    num += dp[i - 1][j - arr[i] * k];
                }
                dp[i][j] = num;
            }
        }
        return dp[arr.length - 1][aim];
    }

    public static void main(String[] args) {

        int[] ints = {5, 10, 25, 1};
        System.out.println(coins1(ints, 100));
    }

    public static int process1(int[] arr, int index, int aim) {

        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            // 每个金额从零个开始计算
            for (int i = 0; arr[index] * i <= aim; i++) {
                res += process1(arr, index + 1, aim - arr[index] * i);
            }
        }
        return res;
    }

    public static int process2(int[] arr, int index, int aim, int[][] map) {

        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            int mapValue = 0;
            for (int i = 0; arr[index] * i <= aim; i++) {
                // 先查缓存表，缓存表不存在则走递归
                mapValue = map[index + 1][aim - arr[index] * i];
                if (mapValue != 0) {
                    res += mapValue == -1 ? 0 : mapValue;
                } else {
                    res += process2(arr, index + 1, aim - arr[index] * i, map);
                }
            }
        }
        // 将第 index 位上目标为 aim 的方法数进行缓存
        map[index][aim] = res == 0 ? -1 : res;
        return res;
    }

}
