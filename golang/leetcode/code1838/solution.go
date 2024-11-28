package code1838

import "sort"

func maxFrequency(nums []int, k int) (res int) {
	sort.Ints(nums)
	for i, j, sum, n := 0, 0, 0, len(nums); j < n; {
		for ; j < n && (j-i+1)*nums[j] <= sum+k+nums[j]; j++ {
			sum += nums[j]
		}
		res = max(res, j-i)
		for ; j < n && (j-i+1)*nums[j] > sum+k+nums[j]; i++ {
			sum -= nums[i]
		}
	}
	return
}
