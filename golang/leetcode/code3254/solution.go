package code3254

func resultsArray(nums []int, k int) []int {
	n := len(nums)
	dp := make([][]bool, n)
	for i := range n {
		dp[i] = make([]bool, k)
		dp[i][0] = true
	}
	for i := 1; i < k; i++ {
		for j := 0; j+i < n; j++ {
			dp[j][i] = dp[j][i-1] && (nums[j+i-1]+1 == nums[j+i])
		}
	}
	res := make([]int, n-k+1)
	for i := 0; i < n-k+1; i++ {
		if dp[i][k-1] {
			res[i] = nums[i+k-1]
		} else {
			res[i] = -1
		}
	}
	return res
}
