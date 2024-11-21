package code3243

func shortestDistanceAfterQueries(n int, queries [][]int) []int {
	right := make([]int, n)
	for i := 0; i < n; i++ {
		right[i] = i + 1
	}
	var res []int
	dist := n - 1
	for _, query := range queries {
		k := right[query[0]]
		for k != -1 && k < query[1] {
			right[query[0]] = query[1]
			k, right[k] = right[k], -1
			dist--
		}
		res = append(res, dist)
	}
	return res
}
