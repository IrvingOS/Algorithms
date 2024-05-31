package main

func findMissingAndRepeatedValues(grid [][]int) []int {
	n := len(grid)
	flag := make([]int, n*n+1)
	flag[0] = 1
	for row := range grid {
		for col := range grid[row] {
			flag[grid[row][col]]++
		}
	}
	a, b := 0, 0
	for i, v := range flag {
		if v == 0 {
			b = i
		}
		if v == 2 {
			a = i
		}
	}
	return []int{a, b}
}
