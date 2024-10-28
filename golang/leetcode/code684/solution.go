package code684

func findRedundantConnection(edges [][]int) []int {
	n := len(edges)
	parents := make([]int, n+1)
	for i := 1; i <= n; i++ {
		parents[i] = i
	}
	for _, edge := range edges {
		if find(parents, edge[0]) == find(parents, edge[1]) {
			return edge
		} else {
			union(parents, edge[0], edge[1])
		}
	}
	return []int{}
}

func find(parents []int, index int) int {
	if parents[index] != index {
		return find(parents, parents[index])
	}
	return index
}

func union(parents []int, node1, node2 int) {
	parent1 := find(parents, node1)
	parent2 := find(parents, node2)
	parents[parent1] = parent2
}
