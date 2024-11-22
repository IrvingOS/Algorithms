package code2134

func minSwaps(nums []int) int {
	m, n := 0, len(nums)
	for _, num := range nums {
		if num == 1 {
			m++
		}
	}
	i, j, cur := 0, 0, 0
	for j < m {
		cur += nums[j]
		j++
	}
	maxC := cur
	for j < n+m {
		cur += nums[j%n]
		cur -= nums[i]
		maxC = max(maxC, cur)
		i++
		j++
	}
	return m - maxC
}
