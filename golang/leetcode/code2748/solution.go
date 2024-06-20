package code2748

import "strconv"

func countBeautifulPairs(nums []int) int {
	n := len(nums)
	var gcd func(a, b uint8) uint8
	gcd = func(a, b uint8) uint8 {
		if a%b == 0 {
			return b
		}
		return gcd(b, a%b)
	}
	res := 0
	for i := 0; i < n; i++ {
		first := strconv.Itoa(nums[i])[0] - '0'
		for j := i + 1; j < n; j++ {
			last := uint8(nums[j] % 10)
			if gcd(first, last) == 1 {
				res++
			}
		}
	}
	return res
}
