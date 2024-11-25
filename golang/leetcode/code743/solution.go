package code743

func networkDelayTime(times [][]int, n int, k int) int {
	graph := make([][][2]int, n)
	for _, time := range times {
		sre := time[0] - 1
		dest := time[1] - 1
		cost := time[2]
		if graph[sre] == nil {
			graph[sre] = [][2]int{}
		}
		graph[sre] = append(graph[sre], [2]int{dest, cost})
	}
	queue := [][2]int{{k - 1, 0}}
	costs := make([]int, n)
	costs[k-1] = -1
	maxCost := 0
	for len(queue) != 0 {
		step := queue[0]
		cur, cost := step[0], step[1]
		for _, next := range graph[cur] {
			if costs[next[0]] == 0 || costs[next[0]] > cost+next[1] {
				costs[next[0]] = cost + next[1]
				queue = append(queue, [2]int{next[0], costs[next[0]]})
			}
		}
		queue = queue[1:]
	}
	for _, cost := range costs {
		if cost == 0 {
			return -1
		}
		maxCost = max(maxCost, cost)
	}
	return maxCost
}
