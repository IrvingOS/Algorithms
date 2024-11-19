package code3243

func shortestDistanceAfterQueries(n int, queries [][]int) []int {
	neighbors := make([][]int, n)
	for i := 0; i < n-1; i++ {
		neighbors[i] = append(neighbors[i], i+1)
	}
	var res []int
	for _, query := range queries {
		neighbors[query[0]] = append(neighbors[query[0]], query[1])
		res = append(res, bfs(n, neighbors))
	}
	return res
}

func bfs(n int, neighbors [][]int) int {
	dist := make([]int, n)
	for i := 0; i < n; i++ {
		dist[i] = -1
	}
	queue := []int{0}
	dist[0] = 0
	for len(queue) > 0 {
		cur := queue[0]
		for _, next := range neighbors[cur] {
			if dist[next] != -1 {
				continue
			}
			dist[next] = dist[cur] + 1
			queue = append(queue, next)
		}
		queue = queue[1:]
	}
	return dist[n-1]
}
