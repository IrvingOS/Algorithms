package main

import "math"

func numRollsToTarget(n int, k int, target int) int {
	dp := make([][]int, n+1)
	for i := 0; i < n+1; i++ {
		dp[i] = make([]int, target+1)
	}
	dp[0][0] = 1
	for i := 1; i <= n; i++ {
		for c := 1; c <= k; c++ {
			maxJ := int(math.Min(float64(i*k), float64(target)))
			for j := c + i - 1; j <= maxJ; j++ {
				dp[i][j] += dp[i-1][j-c]
				if dp[i][j] >= 1_000_000_007 {
					dp[i][j] %= 1_000_000_007
				}
			}
		}
	}
	return dp[n][target]
}
