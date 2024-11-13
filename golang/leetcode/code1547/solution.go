package code1547

import (
	"math"
	"sort"
)

func minCost(n int, cuts []int) int {
	m := len(cuts)
	sort.Ints(cuts)
	fCuts := make([]int, m+2)
	for i := 0; i < m; i++ {
		fCuts[i+1] = cuts[i]
	}
	fCuts[0], fCuts[m+1] = 0, n
	dp := make([][]int, m+2)
	for i := 0; i < m+2; i++ {
		dp[i] = make([]int, m+2)
	}
	for i := m; i >= 1; i-- {
		for j := i; j <= m; j++ {
			if i != j {
				dp[i][j] = math.MaxInt
			}
			for k := i; k <= j; k++ {
				dp[i][j] = min(dp[i][j], dp[i][k-1]+dp[k+1][j])
			}
			dp[i][j] += fCuts[j+1] - fCuts[i-1]
		}
	}
	return dp[1][m]
}
