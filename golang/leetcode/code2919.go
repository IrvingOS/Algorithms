package main

import "math"

func minIncrementOperationsDFS(nums []int, k int) int64 {
	n := len(nums)
	visited := map[int]map[int64]bool{}
	var result int64 = math.MaxInt64
	min := func(x, y int64) int64 {
		if x < y {
			return x
		}
		return y
	}
	max := func(x, y int64) int64 {
		if x < y {
			return y
		}
		return x
	}
	var dfs func(start int, count int64)
	dfs = func(start int, count int64) {
		if start+3 > n {
			result = min(result, count)
			return
		}
		if _, ok := visited[start][count]; ok {
			return
		} else if _, ok := visited[start]; ok {
			visited[start][count] = true
		} else {
			visited[start] = map[int64]bool{}
			visited[start][count] = true
		}
		for i := start; i < start+3; i++ {
			dfs(i+1, count+max(int64(k-nums[i]), 0))
		}
	}
	dfs(0, 0)
	if result == math.MaxInt64 {
		return 0
	}
	return result
}

func minIncrementOperations(nums []int, k int) int64 {
	f0, f1, f2 := 0, 0, 0
	for _, x := range nums {
		inc := f0 + max(k-x, 0)
		f0 = min(inc, f1)
		f1 = min(inc, f2)
		f2 = inc
	}
	return int64(f0)
}
