package code2968

import (
	"sort"
)

func maxFrequencyScore(nums []int, k int64) (res int) {
	sort.Ints(nums)
	n := len(nums)
	sum := make([]int64, n+1)
	for i := 0; i < n; i++ {
		sum[i+1] = sum[i] + int64(nums[i])
	}
	diff := func(l, m, r int) (res int64) {
		return int64((m-l)*nums[m]) - (sum[m] - sum[l]) + sum[r+1] - sum[m+1] - int64((r-m)*nums[m])
	}
	left := 0
	for right := range nums {
		for diff(left, (right+left)/2, right) > k {
			left++
		}
		res = max(res, right-left+1)
	}
	return
}
