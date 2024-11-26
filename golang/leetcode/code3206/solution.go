package code3206

func numberOfAlternatingGroups(colors []int) int {
	n := len(colors)
	res := 0
	for i := 0; i < n; i++ {
		if colors[i] == colors[(i+2)%n] && colors[i] != colors[(i+1)%n] {
			res++
		}
	}
	return res
}
