package leetcode

import "math"

/**
 * MAX_INT: 2^31 - 1 = 2147483647
 * MIN_INT:  - 2^31  = -2147483648
 */
func reverse(x int) int {
	rev := 0

	for x != 0 {
		pop := x % 10
		if rev > math.MaxInt32/10 || (rev == math.MaxInt32/10 && pop > 7) {
			return 0
		}
		if rev < math.MinInt32/10 || (rev == math.MinInt32/10 && pop < -8) {
			return 0
		}
		rev = rev*10 + pop
		x /= 10
	}
	return rev
}
