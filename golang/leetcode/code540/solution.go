package code540

func singleNonDuplicate(nums []int) int {
	n := len(nums)
	l, r := 0, n-1
	for l < r {
		m := l + (r-l)/2
		if nums[m] != nums[m^1] {
			r = m
		} else {
			l = m + 1
		}
	}
	return nums[l]
}
