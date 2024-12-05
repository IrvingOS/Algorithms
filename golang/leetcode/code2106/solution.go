package code2106

func maxTotalFruits(fruits [][]int, startPos int, k int) (res int) {
	for i, j, cur, n := 0, 0, 0, len(fruits); i < n; i++ {
		if startPos-fruits[i][0] <= k {
			for j = i; j < n && fruits[j][0] <= startPos; j++ {
				cur += fruits[j][1]
			}
			res = cur
			for l, r := i, j; r < n && fruits[r][0]-startPos <= k; r++ {
				cur += fruits[r][1]
				for startPos-fruits[l][0]+fruits[r][0]-fruits[l][0] > k && fruits[r][0]-fruits[l][0]+fruits[r][0]-startPos > k {
					cur -= fruits[l][1]
					l++
				}
				res = max(res, cur)
			}
			break
		}
	}
	return
}
