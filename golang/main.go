package main

import "math"

func main() {

	println(maximumSumSubsequence([]int{0, 3, 3, 3, 1, -2}, [][]int{{4, 0}, {1, 0}}))
}

const MOD = 1000000007

func maximumSumSubsequence(nums []int, queries [][]int) int {
	n := len(nums)
	tree := NewSegTree(n)
	tree.init(nums)

	ans := int64(0)
	for _, q := range queries {
		tree.update(q[0], q[1])
		ans = (ans + tree.query()) % MOD
	}
	return int(ans)
}

type SegNode struct {
	v00, v01, v10, v11 int64
}

func (sn *SegNode) best() int64 {
	return sn.v11
}

func (sn *SegNode) set(v int64) {
	sn.v00, sn.v01, sn.v10 = 0, 0, 0
	sn.v11 = int64(math.Max(float64(v), 0))
}

func NewSegNode() *SegNode {
	return &SegNode{0, 0, 0, 0}
}

type SegTree struct {
	n    int
	tree []*SegNode
}

func (st *SegTree) init(nums []int) {
	st.internalInit(nums, 1, 1, st.n)
}

func (st *SegTree) update(x, v int) {
	st.internalUpdate(1, 1, st.n, x+1, int64(v))
}

func (st *SegTree) query() int64 {
	return st.tree[1].best()
}

func (st *SegTree) internalInit(nums []int, x int, l int, r int) {
	if l == r {
		st.tree[x].set(int64(nums[l-1]))
		return
	}
	mid := (l + r) / 2
	st.internalInit(nums, x*2, l, mid)
	st.internalInit(nums, x*2+1, mid+1, r)
	st.pushUp(x)
}

func (st *SegTree) internalUpdate(x int, l int, r int, pos int, v int64) {
	if l > pos || r < pos {
		return
	}
	if l == r {
		st.tree[x].set(v)
		return
	}
	mid := (l + r) / 2
	st.internalUpdate(x*2, l, mid, pos, v)
	st.internalUpdate(x*2+1, mid+1, r, pos, v)
	st.pushUp(x)
}

func (st *SegTree) pushUp(x int) {
	l, r := x*2, x*2+1
	st.tree[x].v00 = max(st.tree[l].v00+st.tree[r].v10, st.tree[l].v01+st.tree[r].v00)
	st.tree[x].v01 = max(st.tree[l].v00+st.tree[r].v11, st.tree[l].v01+st.tree[r].v01)
	st.tree[x].v10 = max(st.tree[l].v10+st.tree[r].v10, st.tree[l].v11+st.tree[r].v00)
	st.tree[x].v11 = max(st.tree[l].v10+st.tree[r].v11, st.tree[l].v11+st.tree[r].v01)
}

func NewSegTree(n int) *SegTree {
	tree := make([]*SegNode, n*4+1)
	for i := range tree {
		tree[i] = NewSegNode()
	}
	return &SegTree{n, tree}
}
