package code1004

func longestOnes(nums []int, k int) (res int) {
	for i, j, cnt, n := 0, 0, 0, len(nums); j < n; i++ {
		for ; j < n && (cnt < k || nums[j] != 0); j++ {
			if nums[j] == 0 {
				cnt++
			}
		}
		res = max(res, j-i)
		for ; i < n && nums[i] == 1; i++ {
		}
		cnt--
	}
	return
}
