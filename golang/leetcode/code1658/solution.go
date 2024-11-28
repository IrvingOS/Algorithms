package code1658

func minOperations(nums []int, x int) int {
	sum := 0
	for _, num := range nums {
		sum += num
	}
	target := sum - x
	if target < 0 {
		return -1
	} else if target == 0 {
		return len(nums)
	}
	m, n := 0, len(nums)
	for i, j, cur := 0, 0, 0; j < n; {
		for ; j < n && cur < target; j++ {
			cur += nums[j]
		}
		for ; cur > target; i++ {
			cur -= nums[i]
		}
		if cur == target {
			m = max(m, j-i)
			cur -= nums[i]
			i++
		}
	}
	if m == 0 {
		return -1
	}
	return n - m
}
