package code3258

func countKConstraintSubstrings(s string, k int) int {
	n := len(s)
	res := 0
	for i := 0; i < n; i++ {
		j := i
		count := make([]int, 2)
		for ; j < n; j++ {
			count[s[j]-'0']++
			if count[0] > k && count[1] > k {
				break
			}
			res++
		}
	}
	return res
}
