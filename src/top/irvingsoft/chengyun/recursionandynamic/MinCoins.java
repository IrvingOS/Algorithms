package top.irvingsoft.chengyun.recursionandynamic;

/**
 * Page 209
 *
 * @author TimeChaser
 * @date 2021/9/25 15:34
 */
public class MinCoins {

    /**
     * 0/1 背包问题
     * <p>
     * 数组内的元素均只有其各自一个
     *
     * @author TimeChaser
     * @date 2021/9/25 21:54
     */
    public static int minCoins1(int[] arr, int aim) {

        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[n][aim + 1];
        for (int j = 1; j <= aim; j++) {
            dp[0][j] = max;
            if (j - arr[0] >= 0 && dp[0][j - arr[0]] != max) {
                dp[0][j] = dp[0][j - arr[0]] + 1;
            }
        }
        int left = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= aim; j++) {
                left = max;
                if (j - arr[i] >= 0 && dp[i][j - arr[i]] != max) {
                    left = dp[i][j - arr[i]] + 1;
                }
                dp[i][j] = Math.min(left, dp[i - 1][j]);
            }
        }
        return dp[n - 1][aim] != max ? dp[n - 1][aim] : -1;
    }

    public static int minCoins2(int[] arr, int aim) {

        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[] dp = new int[aim + 1];
        for (int j = 1; j <= aim; j++) {
            dp[j] = max;
            if (j - arr[0] >= 0 && dp[j - arr[0]] != max) {
                dp[j] = dp[j - arr[0]] + 1;
            }
        }
        int left = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= aim; j++) {
                left = max;
                if (j - arr[i] >= 0 && dp[j - arr[i]] != max) {
                    left = dp[j - arr[i]] + 1;
                }
                dp[j] = Math.min(left, dp[j]);
            }
        }
        return dp[aim] != max ? dp[aim] : -1;
    }

    /**
     * 完全背包问题：
     * <p>
     * 数组内的元素均有无数个
     *
     * @author TimeChaser
     * @date 2021/9/25 21:52
     */
    public static int minCoins3(int[] arr, int aim) {

        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }

        int n = arr.length;
        int[][] dp = new int[n][aim + 1];
        int max = Integer.MAX_VALUE;
        for (int j = 1; j <= aim; j++) {
            dp[0][j] = max;
        }
        if (arr[0] <= aim) {
            dp[0][arr[0]] = 1;
        }
        int leftUp;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= aim; j++) {
                leftUp = max;
                if (j - arr[i] >= 0 && dp[i - 1][j - arr[i]] != max) {
                    leftUp = dp[i - 1][j - arr[i]] + 1;
                }
                dp[i][j] = Math.min(leftUp, dp[i - 1][j]);
            }
        }

        return dp[n - 1][aim] != max ? dp[n - 1][aim] : -1;
    }

    public static int minCoins4(int[] arr, int aim) {

        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }

        int n = arr.length;
        int[] dp = new int[aim + 1];
        int max = Integer.MAX_VALUE;
        for (int j = 1; j <= aim; j++) {
            dp[j] = max;
        }
        if (arr[0] <= aim) {
            dp[arr[0]] = 1;
        }
        int leftUp = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= aim; j++) {
                leftUp = max;
                if (j - arr[i] >= 0 && dp[j - arr[i]] != max) {
                    leftUp = dp[j - arr[i]] + 1;
                }
                dp[j] = Math.max(leftUp, dp[j]);
            }
        }

        return dp[aim] != max ? dp[aim] : -1;
    }

    public static void main(String[] args) {

        int[] ints = {5, 2, 3, 5};
        System.out.println(minCoins1(ints, 20));
        System.out.println(minCoins3(ints, 2));
    }
}
