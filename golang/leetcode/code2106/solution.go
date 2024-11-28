package code2106

func maxTotalFruits(fruits [][]int, startPos int, k int) int {
	l, n := 0, len(fruits)
	for i := 0; i < n; i++ {
		if abs(fruits[i][0]-startPos) <= k {
			l = i
			break
		}
	}
	res := 0

	return res
}

func abs(x int) int {
	if x < 0 {
		return -x
	}
	return x
}
