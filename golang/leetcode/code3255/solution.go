package code3254

func resultsArray(nums []int, k int) []int {
	n := len(nums)
	res := make([]int, n-k+1)
	cnt := 0
	for i := 0; i < n; i++ {
		if i == 0 || nums[i-1]+1 != nums[i] {
			cnt = 1
		} else {
			cnt++
		}
		if cnt >= k {
			res[i-k+1] = nums[i]
		} else if i >= k-1 {
			res[i-k+1] = -1
		}

	}
	return res
}
