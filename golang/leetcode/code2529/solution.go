package code2529

func maximumCount(nums []int) int {
	return max(lowerBound(nums, 0), len(nums)-lowerBound(nums, 1))
}

func lowerBound(nums []int, val int) int {
	left, right := 0, len(nums)
	for left < right {
		mid := (left + right) / 2
		if nums[mid] >= val {
			right = mid
		} else {
			left = mid + 1
		}
	}
	return left
}
