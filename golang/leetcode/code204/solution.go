package code204

func countPrimes(n int) int {
	res := 0
	for i := 2; i < n; i++ {
		if isPrimes(i) {
			res++
		}
	}
	return res
}

func isPrimes(x int) bool {
	for i := 2; i*i <= x; i++ {
		if x%i == 0 {
			return false
		}
	}
	return true
}
