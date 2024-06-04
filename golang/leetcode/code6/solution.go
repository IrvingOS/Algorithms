package code6

import (
	"fmt"
	"strings"
)

func convert(s string, numRows int) string {
	if numRows == 1 {
		return s
	}
	n := len(s)
	grid := make([][]string, numRows)
	for i := range grid {
		grid[i] = make([]string, n)
	}
	up := false
	i, j := 0, 0
	for k := 0; k < n; k++ {
		fmt.Println(i, j)
		grid[i][j] = s[k : k+1]
		if up {
			j++
			i--
			if i == -1 {
				i = 1
				j--
				up = false
			}
		} else {
			i++
			if i == numRows {
				i -= 2
				j++
				up = true
			}
		}
	}
	result := ""
	for i := 0; i < numRows; i++ {
		result += strings.Join(grid[i], "")
	}
	return result
}
