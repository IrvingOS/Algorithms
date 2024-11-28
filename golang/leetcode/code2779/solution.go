package code2779

import "sort"

// 最长子序列，与顺序无关，先排序
// 美丽数组：右边界和左边界的差值不超过 2*k
func maximumBeauty(nums []int, k int) int {
	sort.Ints(nums)
	res := 0
	for i, j, n := 0, 1, len(nums); i < n; i++ {
		for ; j < n && nums[j]-nums[i] <= 2*k; j++ {
		}
		res = max(res, j-i)
	}
	return res
}
