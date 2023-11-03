package main

func minSum(nums1 []int, nums2 []int) int64 {
	zero1, zero2, sum1, sum2 := 0, 0, 0, 0
	for _, v := range nums1 {
		sum1 += v
		if v == 0 {
			zero1++
		}
	}
	for _, v := range nums2 {
		sum2 += v
		if v == 0 {
			zero2++
		}
	}
	if sum1 > sum2 {
		if zero2 == 0 || (zero1 == 0 && zero2+sum2 > sum1) {
			return -1
		}
	} else if sum1 < sum2 {
		if zero1 == 0 || (zero2 == 0 && zero1+sum1 > sum2) {
			return -1
		}
	} else {
		if zero1 == 0 && zero2 != 0 || zero1 != 0 && zero2 == 0 {
			return -1
		}
	}
	return int64(max(sum1+zero1, sum2+zero2))
}
