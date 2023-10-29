package main

func smallestMissingValueSubtree(parents []int, nums []int) []int {
	n := len(parents)
	result := make([]int, n)
	maxNum := 0
	indexOfOne := -1
	child := map[int][]int{}

	for i := 0; i < n; i++ {
		/*默认置为 1*/
		result[i] = 1
		if nums[i] > maxNum {
			maxNum = nums[i]
		}
		/*获取基因为 1 的节点*/
		if nums[i] == 1 {
			indexOfOne = i
		}
		/*构建子节点 map*/
		parent := parents[i]
		if leaf, ok := child[parent]; ok {
			child[parent] = append(leaf, i)
		} else {
			child[parent] = []int{i}
		}
	}

	if indexOfOne == -1 {
		/*nums 中没有 1，则所有的节点缺少的最小基因值都是 1，直接返回 result*/
		return result
	}

	size := maxNum + 1
	set := UnionFoundSet{
		End:         make([]int, size),
		UnionStatus: make([]bool, size),
	}

	cur := indexOfOne
	dfs(cur, &result, nums, child, &set)
	result[cur] = set.Find()
	for {
		parent := parents[cur]
		if parent == -1 {
			break
		}
		leaf := child[parent]
		for i := 0; i < len(leaf); i++ {
			if leaf[i] != cur {
				dfs(leaf[i], &result, nums, child, &set)
			}
		}
		set.Union(nums[parent])
		result[parent] = set.Find()
		cur = parent
	}
	return result
}

func dfs(cur int, result *[]int, nums []int, child map[int][]int, set *UnionFoundSet) {
	leaf, ok := child[cur]
	if ok {
		for i := 0; i < len(leaf); i++ {
			dfs(leaf[i], result, nums, child, set)
		}
	}
	set.Union(nums[cur])
}

type UnionFoundSet struct {
	End         []int
	UnionStatus []bool
}

func (us UnionFoundSet) Find() int {
	i := 2
	for {
		if i == len(us.UnionStatus) || !us.UnionStatus[i] {
			return i
		}
		i = us.End[i] + 1
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
