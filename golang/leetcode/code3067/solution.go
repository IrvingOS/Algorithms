package code3067

func countPairsOfConnectableServers(edges [][]int, signalSpeed int) []int {
	n := len(edges) + 1
	graph := make([][][]int, n)
	for _, edge := range edges {
		u, v, cost := edge[0], edge[1], edge[2]
		graph[u] = append(graph[u], []int{v, cost})
		graph[v] = append(graph[v], []int{u, cost})
	}

	var dfs func(root, cur, cost int) int
	dfs = func(root, cur, cost int) int {
		res := 0
		if cost == 0 {
			res++
		}
		for _, neighbor := range graph[cur] {
			next, nextCost := neighbor[0], neighbor[1]
			if next != root {
				res += dfs(cur, next, (cost+nextCost)%signalSpeed)
			}
		}
		return res
	}

	res := make([]int, n)
	for u := 0; u < n; u++ {
		prev := 0
		for _, neighbor := range graph[u] {
			v, cost := neighbor[0], neighbor[1]
			cur := dfs(u, v, cost%signalSpeed)
			res[u] += prev * cur
			prev += cur
		}
	}
	return res
}
