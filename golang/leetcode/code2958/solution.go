package code2958

func maxSubarrayLength(nums []int, k int) int {
	res := 0
	for i, j, n, cnt := 0, 0, len(nums), make(map[int]int); j < n; j++ {
		cnt[nums[j]]++
		for cnt[nums[j]] > k {
			cnt[nums[i]]--
			i++
		}
		res = max(res, j-i+1)
	}
	return res
}
