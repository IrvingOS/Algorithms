package code2003

/*在多叉树中确定一条链表，从链表的末端节点开始到根节点 dfs*/
func smallestMissingValueSubtree(parents []int, nums []int) []int {
	m := len(parents)
	result := make([]int, m)
	maxNum := 0
	indexOfOne := -1
	child := map[int][]int{}

	for i := 0; i < m; i++ {
		/*默认置为 1*/
		result[i] = 1
		/*最大的基因*/
		if nums[i] > maxNum {
			maxNum = nums[i]
		}
		/*获取基因为 1 的节点*/
		if nums[i] == 1 {
			indexOfOne = i
		}
		/*构建子节点 map*/
		child[parents[i]] = append(child[parents[i]], i)
	}

	if indexOfOne == -1 {
		/*nums 中没有 1，则所有的节点缺少的最小基因值都是 1，直接返回 result*/
		return result
	}

	n := maxNum + 2
	visited := make([]bool, m)
	gens := make([]bool, n)

	var dfs func(node int)
	dfs = func(node int) {
		if visited[node] {
			return
		}
		visited[node] = true
		gens[nums[node]] = true
		for _, i := range child[node] {
			dfs(i)
		}
	}

	cur := indexOfOne
	gen := 2
	for cur != -1 {
		dfs(cur)
		for gens[gen] {
			gen++
		}
		result[cur] = gen
		cur = parents[cur]
	}

	return result
}

type UnionFoundSet struct {
	End         []int
	UnionStatus []bool
	Index       int
}

func (us UnionFoundSet) Find() int {
	for {
		if us.Index == len(us.UnionStatus) || !us.UnionStatus[us.Index] {
			return us.Index
		}
		us.Index = us.End[us.Index] + 1
	}
}

func (us UnionFoundSet) Union(i int) {
	us.UnionStatus[i] = true
	us.End[i] = i
	if i+1 < len(us.UnionStatus) && us.UnionStatus[i+1] {
		us.End[i] = us.End[i+1]
	}
	if i-1 >= 0 && us.UnionStatus[i-1] {
		us.End[i-1] = us.End[i]
	}
}
