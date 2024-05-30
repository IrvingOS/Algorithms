package main

// 从可能的最长长度挨个开始找是否存在该长度能出现三次特殊字符串
func maximumLength(s string) int {
	length := len(s)
	if length < 3 {
		return -1
	}
	// 用来标记特殊字符串
	flag := make([]int, length)
	flag[0] = 0
	for i := 1; i < length; i++ {
		if s[i-1] == s[i] {
			flag[i] = flag[i-1]
		} else {
			flag[i] = flag[i-1] + 1
		}
	}
	maxSubLen := length - 2
	for maxSubLen > 0 {
		counter := make(map[string]int)
		for i := 0; i < length-maxSubLen+1; i++ {
			if flag[i] != flag[i+maxSubLen-1] {
				// 不是特殊字符串
				continue
			}
			sub := s[i : i+maxSubLen]
			counter[sub]++
			if counter[sub] == 3 {
				return maxSubLen
			}
		}
		maxSubLen--
	}
	return -1
}

// 统计所有特殊字符串的长度，找出每个字母前三长的特殊字符串，然后得出答案
func maximumLengthPro(s string) int {
	ans := -1

	length := len(s)
	chCounts := make([][]int, 26)
	count := 0

	for i := 0; i < length; i++ {
		count++

		if i+1 == length || s[i] != s[i+1] {
			j := s[i] - 'a'
			chCounts[j] = append(chCounts[j], count)
			count = 0

			// 每次只会添加一个值，所以一次冒泡就能搞定排序
			for k := len(chCounts[j]) - 1; k > 0; k-- {
				if chCounts[j][k] > chCounts[j][k-1] {
					temp := chCounts[j][k]
					chCounts[j][k] = chCounts[j][k-1]
					chCounts[j][k-1] = temp
				} else {
					break
				}
			}

			// 只需要三个长度，超过三个就截取
			if len(chCounts[j]) > 3 {
				chCounts[j] = chCounts[j][:3]
			}
		}
	}

	for i := 0; i < 26; i++ {
		// aaaa 这种情况 ans = 2
		if len(chCounts[i]) > 0 && chCounts[i][0] > 2 {
			ans = max(ans, chCounts[i][0]-2)
		}
		// aaaaa aaaa 这种情况 ans = 4
		if len(chCounts[i]) > 1 && chCounts[i][0] > 1 {
			ans = max(ans, min(chCounts[i][0]-1, chCounts[i][1]))
		}
		// a a a 这种情况 ans = 1
		if len(chCounts[i]) > 2 {
			ans = max(ans, chCounts[i][2])
		}
	}
	return ans
}
