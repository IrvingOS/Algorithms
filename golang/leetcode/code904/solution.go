package code904

func totalFruit(fruits []int) int {
	n := len(fruits)
	res := 0
	for i, j, a, b := 0, 0, -1, -1; j < n; {
		for j < n && (a == -1 || b == -1 || fruits[j] == a || fruits[j] == b) {
			if a == -1 {
				a = fruits[j]
			} else if fruits[j] != a && b == -1 {
				b = fruits[j]
			}
			j++
		}
		res = max(res, j-i)
		if j < n {
			a, b = fruits[j-1], fruits[j]
			for i = j - 1; i > 0 && fruits[i-1] == a; i-- {
			}
		}
	}
	return res
}
