package main

func longestPalindrome(s string) string {
	n := len(s)
	dp := make([][]int, n)
	for i := range dp {
		dp[i] = make([]int, n)
		dp[i][i] = 1
	}
	maxLen := 1
	result := s[0:1]
	for l := 2; l <= n; l++ {
		for i := 0; i <= n-l; i++ {
			j := i + l - 1
			if s[i] == s[j] {
				if l == 2 {
					dp[i][j] = 2
				} else if dp[i+1][j-1] == l-2 {
					dp[i][j] = l
				}
				if dp[i][j] > maxLen {
					maxLen = dp[i][j]
					result = s[i : j+1]
				}
			}
		}
	}
	return result
}
