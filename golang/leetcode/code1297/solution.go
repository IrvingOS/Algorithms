package code1297

func maxFreq(s string, maxLetters int, minSize int, maxSize int) int {
	n := len(s)
	letters := make([]int, 26)
	countLetter := 0
	m := make(map[string]int)
	var str []rune
	res := 0
	for i := 0; i < n; i++ {
		str = append(str, rune(s[i]))
		u := s[i] - 'a'
		if letters[u] == 0 {
			countLetter++
		}
		letters[u]++
		for countLetter > maxLetters {
			left := str[0]
			letters[left-'a']--
			if letters[left-'a'] == 0 {
				countLetter--
			}
			str = str[1:]
		}
		for len(str) >= minSize && len(str) <= maxSize {
			key := string(str)
			m[key]++
			res = max(res, m[key])
			left := str[0]
			letters[left-'a']--
			if letters[left-'a'] == 0 {
				countLetter--
			}
			str = str[1:]
		}
	}
	return res
}
