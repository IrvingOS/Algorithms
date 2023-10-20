package main

func lengthOfLongestSubstring(s string) int {
	m := map[byte]int{}
	n := len(s)
	j, result := -1, 0
	for i := 0; i < n; i++ {
		if i != 0 {
			delete(m, s[i-1])
		}
		for j+1 < n && m[s[j+1]] == 0 {
			m[s[j+1]]++
			j++
		}
		result = max(result, j-i+1)
	}
	return result
}
