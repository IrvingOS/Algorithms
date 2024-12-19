package code2009

import (
	"sort"
)

func minOperations(nums []int) int {
	sort.Ints(nums)
	n := len(nums)
	res := n
	for i, j, cnt := 0, 0, make(map[int]int); j < n; i++ {
		for ; j < n && nums[j]-nums[i] < n; j++ {
			cnt[nums[j]]++
		}
		res = min(res, n-len(cnt))
		cnt[nums[i]]--
		if cnt[nums[i]] == 0 {
			delete(cnt, nums[i])
		}
	}
	return res
}
