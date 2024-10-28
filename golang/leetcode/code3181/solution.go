package code3181

import (
	"math/big"
	"sort"
)

func maxTotalReward(rewardValues []int) int {
	var singleRewardValue []int
	visited := make(map[int]bool)
	for _, x := range rewardValues {
		if _, ok := visited[x]; !ok {
			singleRewardValue = append(singleRewardValue, x)
			visited[x] = true
		}
	}
	sort.Ints(singleRewardValue)
	f0, f1 := big.NewInt(1), big.NewInt(0)
	for _, x := range singleRewardValue {
		mask, one := big.NewInt(0), big.NewInt(1)
		mask.Sub(mask.Lsh(one, uint(x)), one)
		// 计算 f 的高 x 位
		f1.Lsh(f1.And(f0, mask), uint(x))
		f0.Or(f0, f1)
	}
	// f0 初始为 1，结果去掉初始的位宽
	return f0.BitLen() - 1
}
