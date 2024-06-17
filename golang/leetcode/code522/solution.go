package code522

// 看数据集规模，可以放心大胆的穷举！
func findLUSlength(strs []string) int {
	isSubSeq := func(s, t string) bool {
		if s == t {
			return true
		}
		pS, pT := 0, 0
		for pS < len(s) && pT < len(t) {
			if s[pS] == t[pT] {
				pS++
			}
			pT++
		}
		return pS == len(s)
	}
	res := -1
Loop:
	for i, s := range strs {
		for j, t := range strs {
			if i != j && isSubSeq(s, t) {
				continue Loop
			}
		}
		res = max(res, len(s))
	}
	return res
}
