package code2653

func getSubarrayBeauty(nums []int, k int, x int) []int {
	n := len(nums)
	counts := make([]int, 101)
	getX := func() int {
		l := x
		for k := 0; k < 101; k++ {
			if counts[k] >= l {
				return min(0, k-50)
			}
			l -= counts[k]
		}
		return 0
	}
	i, j := 0, 0
	res := make([]int, n-k+1)
	for j < k {
		counts[nums[j]+50]++
		j++
	}
	res[0] = getX()
	for j < n {
		counts[nums[j]+50]++
		counts[nums[i]+50]--
		res[j-k+1] = getX()
		i++
		j++
	}
	return res
}
