package code2779

import "sort"

/*
注意：此题的目的不是要找到最大的完美值，而是要找到完美序列的最长长度
相当于找到 diff <= 2*k 内的最长子序列的长度
*/
func maximumBeauty(nums []int, k int) int {
	n := len(nums)
	sort.Ints(nums)
	res := 0
	for i, j := 0, 0; i < n; i++ {
		for nums[i]-nums[j] > 2*k {
			j++
		}
		res = max(res, i-j+1)
	}
	return res
}
