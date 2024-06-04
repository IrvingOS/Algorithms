package code10

func isMatch(s string, p string) bool {
	m, n := len(s), len(p)
	dp := make([][]bool, m+1)
	for i := 0; i <= m; i++ {
		dp[i] = make([]bool, n+1)
	}
	dp[0][0] = true
	for i := 0; i <= m; i++ {
		for j := 1; j <= n; j++ {
			if p[j-1] == '*' {
				/*s = ""，p = "a*"，i = 0，j = 2 时，先看将 “a*” 抛弃的匹配情况*/
				/*将 “a*” 抛弃之后，状态由 dp[0][0] 转移过来*/
				dp[i][j] = dp[i][j-2]
				if match(s, p, i, j-1) {
					/*在看将 “a*” 保留的匹配情况*/
					/*如果 s[i-1] 能与 “*” 之前的字符 p[j-2] 匹配上，状态由 s[i-2] 传递过来*/
					/*如果 s[i-2] 能匹配到 p[i-1]（已经包括了抛弃或者保留 “a*” 的情况），那么 s[i-1] 一定能匹配到 p[i-1]*/
					dp[i][j] = dp[i][j] || dp[i-1][j]
				}
			} else if match(s, p, i, j) {
				dp[i][j] = dp[i-1][j-1]
			}
		}
	}
	return dp[m][n]
}

func match(s string, p string, i int, j int) bool {
	if i == 0 {
		return false
	}
	if p[j-1] == '.' {
		return true
	}
	return s[i-1] == p[j-1]
}
