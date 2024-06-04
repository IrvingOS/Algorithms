package code2982

func maximumLengthII(s string) int {
	length := len(s)
	chCount := make([][]int, 26)
	count := 0
	for i := 0; i < length; i++ {
		count++
		if i+1 == length || s[i] != s[i+1] {
			j := s[i] - 'a'
			chCount[j] = append(chCount[j], count)
			count = 0

			for k := len(chCount[j]) - 1; k > 0; k-- {
				if chCount[j][k] > chCount[j][k-1] {
					temp := chCount[j][k]
					chCount[j][k] = chCount[j][k-1]
					chCount[j][k-1] = temp
				} else {
					break
				}
			}

			if len(chCount[j]) > 3 {
				chCount[j] = chCount[j][:3]
			}
		}
	}

	ans := -1
	for i := 0; i < 26; i++ {
		if len(chCount[i]) > 0 && chCount[i][0] > 2 {
			ans = max(ans, chCount[i][0]-2)
		}
		if len(chCount[i]) > 1 && chCount[i][0] > 1 {
			ans = max(ans, min(chCount[i][0]-1, chCount[i][1]))
		}
		if len(chCount[i]) > 2 {
			ans = max(ans, chCount[i][2])
		}
	}

	return ans
}
