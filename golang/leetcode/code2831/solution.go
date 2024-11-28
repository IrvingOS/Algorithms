package code2831

// 可以用最大堆来优化性能
func longestEqualSubarray(nums []int, k int) int {
	res := 1
	for i, j, c, cnt, m, n := 0, 0, -1, make(map[int]int), 0, len(nums); i < n; {
		for ; j < n && (c == -1 || (j-i)-m <= k); j++ {
			cnt[nums[j]]++
			if c == -1 {
				c = nums[j]
				m = 1
			} else if cnt[nums[j]] >= m {
				c = nums[j]
				m = cnt[nums[j]]
			}
		}
		res = max(res, m)
		if c == nums[i] {
			m--
			for k, v := range cnt {
				if v > m {
					c = k
					m = v
					break
				}
			}
		}
		cnt[nums[i]]--
		i++
	}
	return res
}
