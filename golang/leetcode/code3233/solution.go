package code3233

import "math"

func nonSpecialCount(l int, r int) int {
	n := int(math.Sqrt(float64(r)))
	notPrime := make([]bool, n+1)
	res := r - l + 1
	for i := 2; i <= n; i++ {
		if !notPrime[i] {
			if i*i >= l && i*i <= r {
				res--
			}
			for j := i * 2; j <= n; j += i {
				notPrime[j] = true
			}
		}
	}
	return res
}
