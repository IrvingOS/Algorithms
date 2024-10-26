package code3180

import (
	"sort"
)

func maxTotalReward(rewardValues []int) int {
	sort.Ints(rewardValues)
	dp := make([]bool, rewardValues[len(rewardValues)-1]*2)
	dp[0] = true
	res := 0
	for _, value := range rewardValues {
		for i := 2*value - 1; i >= value; i-- {
			dp[i] = dp[i] || dp[i-value]
			if dp[i] {
				if i > res {
					res = i
				}
			}
		}
	}
	return res
}
