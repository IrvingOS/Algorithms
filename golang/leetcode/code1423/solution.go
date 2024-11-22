package code1423

func maxScore(cardPoints []int, k int) int {
	n := len(cardPoints)
	sum := 0
	for _, point := range cardPoints {
		sum += point
	}
	remain := n - k
	if remain == 0 {
		return sum
	}
	i, j := 0, 0
	cur := 0
	for j < remain {
		cur += cardPoints[j]
		j++
	}
	minC := cur
	for j < n {
		cur += cardPoints[j]
		cur -= cardPoints[i]
		minC = min(minC, cur)
		i++
		j++
	}
	return sum - minC
}
