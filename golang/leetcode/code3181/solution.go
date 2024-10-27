package code3180

import (
	"sort"
)

func maxTotalReward(rewardValues []int) int {
	var singleRewardValue []int
	visited := make(map[int]bool)
	for _, v := range rewardValues {
		_, ok := visited[v]
		if !ok {
			singleRewardValue = append(singleRewardValue, v)
			visited[v] = true
		}
	}
	sort.Ints(singleRewardValue)
	dp := make([]bool, singleRewardValue[len(singleRewardValue)-1]*2)
	dp[0] = true
	res := 0
	for i, v := range singleRewardValue {
		if i > 0 && singleRewardValue[i-1] == v {
			continue
		}
		for j := 2*v - 1; j >= v; j-- {
			dp[j] = dp[j] || dp[j-v]
			if dp[j] {
				if j > res {
					res = j
				}
			}
		}
	}
	return res
}
