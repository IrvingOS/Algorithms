package code632

import (
	"sort"
)

// 牛，困难题都让我独立做出来了。最近在刷滑动窗口，这个题目刚好可以用滑动窗口来解！
func smallestRange(nums [][]int) []int {
	k := len(nums)
	valueToArrayIndex := make(map[int]map[int]bool)
	for i, num := range nums {
		for _, value := range num {
			if _, ok := valueToArrayIndex[value]; !ok {
				valueToArrayIndex[value] = make(map[int]bool)
			}
			valueToArrayIndex[value][i] = true
		}
	}
	var values []int
	for value := range valueToArrayIndex {
		values = append(values, value)
	}
	sort.Ints(values)
	lI, rI := 0, 0
	res := []int{values[0], values[len(values)-1]}
	minL := values[len(values)-1] - values[0]
	cnt := make([]int, k)
	for rI < len(values) {
		tail := values[rI]
		for i := range valueToArrayIndex[tail] {
			cnt[i]++
		}
		flag := true
		for flag {
			for _, c := range cnt {
				if c == 0 {
					flag = false
					break
				}
			}
			if flag {
				head := values[lI]
				if tail-head < minL {
					res = []int{head, tail}
					minL = tail - head
				}
				for i := range valueToArrayIndex[head] {
					cnt[i]--
				}
				lI++
			}
		}
		rI++
	}
	return res
}
