package code3239

func minFlips(grid [][]int) int {
	m := len(grid)
	n := len(grid[0])

	rowC := 0
	for i := 0; i < m; i++ {
		j, k := 0, n-1
		for j < k {
			if grid[i][j] != grid[i][k] {
				rowC++
			}
			j++
			k--
		}
	}

	colC := 0
	for i := 0; i < n; i++ {
		j, k := 0, m-1
		for j < k {
			if grid[j][i] != grid[k][i] {
				colC++
			}
			j++
			k--
		}
	}

	return min(rowC, colC)
}
