package code3208

func numberOfAlternatingGroups(colors []int, k int) int {
	n := len(colors)
	res := 0
	for i, j := 0, 0; i < n; {
		for ; j-i+1 < k && colors[j%n] != colors[(j+1)%n]; j++ {
		}
		if j-i+1 == k {
			res++
			i++
		} else {
			i = j + 1
			j = j + 1
		}
	}
	return res
}
