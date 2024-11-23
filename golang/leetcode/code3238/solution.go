package code3238

func winningPlayerCount(n int, pick [][]int) int {
	c := make([]map[int]int, n)
	visited := make([]bool, n)
	res := 0
	for _, p := range pick {
		if c[p[0]] == nil {
			c[p[0]] = make(map[int]int)
		}
		c[p[0]][p[1]]++
		if c[p[0]][p[1]] > p[0] && !visited[p[0]] {
			res++
			visited[p[0]] = true
		}
	}
	return res
}
