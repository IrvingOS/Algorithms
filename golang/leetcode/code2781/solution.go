package code2781

func longestValidSubstring(word string, forbidden []string) (res int) {
	has := make(map[string]bool)
	for _, comb := range forbidden {
		has[comb] = true
	}
	for l, r, n := 0, 0, len(word); r < n; r++ {
		for i := r; i >= l && i > r-10; i-- {
			if _, ok := has[word[i:r+1]]; ok {
				l = i + 1
			}
		}
		res = max(res, r-l+1)
	}
	return
}
