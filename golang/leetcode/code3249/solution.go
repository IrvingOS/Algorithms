package code3249

func countGoodNodes(edges [][]int) int {
	n := len(edges) + 1
	nodes := make([][]int, n)
	for _, edge := range edges {
		nodes[edge[0]] = append(nodes[edge[0]], edge[1])
		nodes[edge[1]] = append(nodes[edge[1]], edge[0])
	}
	res := 0
	var dfs func(node, parent int) int
	dfs = func(node, parent int) int {
		sum := 1
		cur := -1
		good := true
		for _, child := range nodes[node] {
			if child != parent {
				size := dfs(child, node)
				if cur == -1 {
					cur = size
				} else if cur != size {
					good = false
				}
				sum += size
			}
		}
		if good {
			res++
		}
		return sum
	}
	dfs(0, -1)
	return res
}
