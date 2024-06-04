package code1103

func distributeCandiesII(candies int, numPeople int) []int {
	gets := make([]int, numPeople)
	i := 0
	cur := 1
	for candies > 0 {
		if i == numPeople {
			i = 0
		}
		if cur > candies {
			cur = candies
		}
		gets[i] += cur
		candies -= cur
		cur++
		i++
	}
	return gets
}
