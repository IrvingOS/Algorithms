package code575

func distributeCandies(candyType []int) int {
	n := len(candyType)
	count := make(map[int]bool)
	for _, t := range candyType {
		count[t] = true
	}
	return min(n/2, len(count))
}
