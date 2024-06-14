package code2786

import "math"

func maxScore(nums []int, x int) int64 {
	res := int64(nums[0])
	dp := [2]int64{math.MinInt32, math.MinInt32}
	dp[nums[0]%2] = int64(nums[0])
	for i := 1; i < len(nums); i++ {
		j := nums[i] % 2
		cur := max(dp[j]+int64(nums[i]), dp[1-j]+int64(nums[i])-int64(x))
		res = max(res, cur)
		dp[j] = max(dp[j], cur)
	}
	return res
}
