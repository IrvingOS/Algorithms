package main

func maximumBinaryString(binary string) string {
	n := len(binary)
	s := []rune(binary)
	j := 0
	for i := 0; i < n; i++ {
		if s[i] == '0' {
			for j <= i || (j < n && s[j] == '1') {
				j++
			}
			if j < n {
				s[j] = '1'
				s[i] = '1'
				s[i+1] = '0'
			}
		}
	}
	return string(s)
}
