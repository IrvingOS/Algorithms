package code633

import (
	"math"
)

func judgeSquareSum(c int) bool {
	right := int(math.Floor(math.Sqrt(float64(c))))
	left := 1
	visited := make(map[int]bool)
	for left <= right {
		cur := left * left
		visited[cur] = true
		if visited[c-cur] {
			return true
		}
		left++
	}
	return false
}
