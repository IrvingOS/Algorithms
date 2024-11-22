package code1888

// 非常经典的滑动窗口，很难想到此解法
func minFlips(s string) int {
	n := len(s)
	// 只有两种串，01~、10~，所以只要算出符合 01~ 的字符数就能得出 10~ 的字符数
	pattern := "01"
	cnt := 0
	for i := 0; i < n; i++ {
		if s[i] == pattern[i%2] {
			cnt++
		}
	}
	res := min(cnt, n-cnt)
	for i := n; i < n*2; i++ {
		if s[i%n] == pattern[i%2] {
			cnt++
		}
		if s[i-n] == pattern[(i-n)%2] {
			cnt--
		}
		res = min(res, min(cnt, n-cnt))
	}
	return res
}
