package code3211

import (
	"strconv"
	"strings"
)

func validStrings(n int) []string {
	var res []string
	visited := make(map[string]bool)
	var dfs func(cur []rune)
	dfs = func(cur []rune) {
		if len(cur) == n {
			comb := string(cur)
			if !visited[comb] {
				res = append(res, comb)
				visited[comb] = true
			}
			return
		}
		if len(cur) == 0 || cur[len(cur)-1] == '1' {
			dfs(append(cur, '0'))
		}
		dfs(append(cur, '1'))
	}
	dfs([]rune{})

	return res
}

func validStrings2(n int) []string {
	var res []string
	mask := (1 << n) - 1
	for i := 0; i < 1<<n; i++ {
		// 按位取反，0 -> 1，1 -> 0
		// 不取反只能通过 (t>>1)&t != 0 证明有两个 1 相邻
		t := mask ^ i
		// (t<<1)&t == 0 也是可以的，只要错开一位
		if (t>>1)&t == 0 {
			str := strconv.FormatInt(int64(i), 2)
			sb := strings.Builder{}
			for j := n - len(str); j > 0; j-- {
				sb.WriteString("0")
			}
			sb.WriteString(str)
			res = append(res, sb.String())
		}
	}
	return res
}
