package code1695

func maximumUniqueSubarray(nums []int) int {
	n := len(nums)
	cnt := make(map[int]int)
	res := nums[0]
	for i, j, cur := 0, 0, 0; j < n; j++ {
		cnt[nums[j]]++
		cur += nums[j]
		for cnt[nums[j]] > 1 {
			cnt[nums[i]]--
			cur -= nums[i]
			i++
		}
		res = max(res, cur)
	}
	return res
}
