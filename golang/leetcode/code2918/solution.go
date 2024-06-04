package code2918

import "fmt"

func findKOr(nums []int, k int) int {
	n := len(nums)
	counts := make([]int, 32)
	result := 0
	for i := 0; i < 32; i++ {
		for j := 0; j < n; j++ {
			if nums[j]&(1<<i) == 1<<i {
				counts[i]++
			}
		}
		fmt.Println(counts[i])
		if counts[i] >= k {
			result += 1 << i
		}
	}
	return result
}
