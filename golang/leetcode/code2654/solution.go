package code2654

import (
	"math"
)

func minOperations2654(nums []int) int {
	n := len(nums)
	count1 := 0
	for _, num := range nums {
		if num == 1 {
			count1++
		}
	}
	if count1 > 0 {
		return n - count1
	}
	res := math.MaxInt
	for j := n - 1; j > 0; j-- {
		k := nums[j]
		for i := j - 1; i >= 0; i-- {
			k = gcd(nums[i], k)
			if k == 1 {
				res = min(res, n+(j-i-1))
			}
		}
	}
	if res == math.MaxInt {
		return -1
	}
	return res
}

func gcd(i int, j int) int {
	r := 0
	for j > 0 {
		r = i % j
		i = j
		j = r
	}
	return i
}
