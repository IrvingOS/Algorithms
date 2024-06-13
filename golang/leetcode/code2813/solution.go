package code2813

import (
	"sort"
)

func findMaximumElegance(items [][]int, k int) int64 {
	sort.Slice(items, func(i, j int) bool {
		return items[i][0] > items[j][0]
	})
	categorySet := make(map[int]bool)
	var res, profit int64
	var moreThenOnce []int // 重复出现过的类别的多余值（理想情况是每个类别取一个最大值）
	for i, item := range items {
		if i < k {
			if categorySet[item[1]] {
				moreThenOnce = append(moreThenOnce, item[0])
			} else {
				categorySet[item[1]] = true
			}
			profit += int64(item[0])
		} else if !categorySet[item[1]] && len(moreThenOnce) > 0 {
			// 出现没有见过的类别，就用这个值替换重复出现过的类别的最小值
			profit += int64(item[0] - moreThenOnce[len(moreThenOnce)-1])
			moreThenOnce = moreThenOnce[:len(moreThenOnce)-1]
			categorySet[item[1]] = true
		}
		res = max(res, profit+int64(len(categorySet)*len(categorySet)))
	}
	return res
}
