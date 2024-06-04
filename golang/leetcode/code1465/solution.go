package code1465

import "sort"

func maxArea(h int, w int, horizontalCuts []int, verticalCuts []int) int {
	hLen := len(horizontalCuts) + 2
	vLen := len(verticalCuts) + 2
	horizontal := make([]int, hLen)
	vertical := make([]int, vLen)
	horizontal = append(horizontalCuts, 0, h)
	vertical = append(verticalCuts, 0, w)
	sort.Ints(horizontal)
	sort.Ints(vertical)

	maxH, maxW := 0, 0
	for i := 1; i < hLen; i++ {
		diff := horizontal[i] - horizontal[i-1]
		if diff > maxH {
			maxH = diff
		}
	}
	for i := 1; i < vLen; i++ {
		diff := vertical[i] - vertical[i-1]
		if diff > maxW {
			maxW = diff
		}
	}
	return maxH * maxW % 1000000007
}
