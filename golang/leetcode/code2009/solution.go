package code2009

import (
	"sort"
)

func minOperations(nums []int) int {
	n := len(nums)
	res := n
	if res == 1 {
		return 0
	}
	sort.Ints(nums)
	i, j := 0, 1
	count := make(map[int]int)
	count[nums[i]]++
	for j < n {
		for j < n && nums[i]+n-1 >= nums[j] {
			count[nums[j]]++
			j++
		}
		res = min(res, n-len(count))
		count[nums[i]]--
		if count[nums[i]] == 0 {
			delete(count, nums[i])
		}
		i++
	}
	if res == n {
		return 0
	}
	return res
}
