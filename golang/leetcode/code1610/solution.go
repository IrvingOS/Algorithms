package code1610

import (
	"math"
	"sort"
)

func visiblePoints(points [][]int, angle int, location []int) (res int) {
	cnt := 0
	var degrees []float64
	for _, point := range points {
		if point[0] == location[0] && point[1] == location[1] {
			cnt++
			continue
		}
		d := math.Atan2(float64(point[1]-location[1]), float64(point[0]-location[0])) / math.Pi * 180
		if d < 0 {
			d += 360
		}
		degrees = append(degrees, d)
	}
	sort.Float64s(degrees)
	n := len(degrees)
	if n == 0 || degrees[n-1]-degrees[0] <= float64(angle) {
		return len(points)
	}
	for i, j := 0, 0; i < n; i++ {
		for j-i < n {
			if j < n && degrees[j]-degrees[i] > float64(angle) {
				break
			} else if j >= n && degrees[j%n]+360-degrees[i] > float64(angle) {
				break
			}
			j++
		}
		res = max(res, j-i+cnt)
	}
	return
}
