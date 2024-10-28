package code685

func findRedundantDirectedConnection(edges [][]int) []int {
	n := len(edges)
	unionFind := NewUnionFind(n + 1)
	parents := make([]int, n+1)
	for to := 1; to <= n; to++ {
		parents[to] = to
	}

	var conflictEdge, cycleEdge []int
	for _, edge := range edges {
		from, to := edge[0], edge[1]
		if parents[to] != to {
			conflictEdge = edge
		} else {
			parents[to] = from
			if unionFind.find(from) == unionFind.find(to) {
				cycleEdge = edge
			} else {
				unionFind.union(from, to)
			}
		}
	}

	if conflictEdge == nil {
		return cycleEdge
	} else if cycleEdge == nil {
		return conflictEdge
	}
	return []int{parents[conflictEdge[1]], conflictEdge[1]}

}

type UnionFind struct {
	ancestor []int
}

func NewUnionFind(n int) *UnionFind {
	instance := &UnionFind{
		ancestor: make([]int, n),
	}
	for i := 0; i < n; i++ {
		instance.ancestor[i] = i
	}
	return instance
}

func (u *UnionFind) find(node int) int {
	if u.ancestor[node] != node {
		return u.find(u.ancestor[node])
	}
	return node
}

func (u *UnionFind) union(node1, node2 int) {
	ancestor1 := u.find(node1)
	ancestor2 := u.find(node2)
	u.ancestor[ancestor2] = ancestor1
}
