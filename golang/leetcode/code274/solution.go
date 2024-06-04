package code274

import "sort"

func hIndex(citations []int) int {
	n := len(citations)
	sort.Ints(citations)
	h := n
	for h > 0 {
		i := n - h
		if citations[i] >= h {
			break
		}
		h--
	}
	return h
}
