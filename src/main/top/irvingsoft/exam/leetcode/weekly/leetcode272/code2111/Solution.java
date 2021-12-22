package top.irvingsoft.exam.leetcode.weekly.leetcode272.code2111;

/**
 * 使数组 K 递增的最少操作数
 * <p>
 * 即求每一个 K 数组的最长递增子序列的长度
 *
 * @author TimeChaser
 * @since 2021/12/21 15:57
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.kIncreasing(new int[]{12, 6, 12, 6, 14, 2, 13, 17, 3, 8, 11, 7, 4, 11, 18, 8, 8, 3}, 1));
    }

    public int kIncreasing(int[] arr, int k) {
        int result = 0;
        int n = arr.length;
        for (int i = 0; i < k; i++) {
            int m = n % k == 0 ? n / k : (i < n - n / k * k ? n / k + 1 : n / k);
            int[] kArray = new int[m];
            int j = i;
            int x = 0;
            while (j < n) {
                kArray[x++] = arr[j];
                j += k;
            }
            int maxLength = lengthOfLIS(kArray);
            result += m - maxLength;
        }
        return result;
    }

    /**
     * 最长递增子序列的长度
     */
    private int lengthOfLIS(int[] nums) {
        int len = 1;
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[len] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] >= dp[len]) {
                dp[++len] = nums[i];
            } else {
                int lo = 1;
                int hi = len;
                int pos = 0;
                while (lo <= hi) {
                    int mid = lo + (hi - lo) / 2;
                    if (dp[mid] <= nums[i]) {
                        pos = mid;
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                }
                dp[pos + 1] = nums[i];
            }
        }
        return len;
    }
}
