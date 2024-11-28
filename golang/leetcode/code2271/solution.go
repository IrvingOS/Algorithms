package code2271

import "sort"

func maximumWhiteTiles(tiles [][]int, carpetLen int) (res int) {
	for _, tile := range tiles {
		if tile[1]-tile[0]+1 >= carpetLen {
			return carpetLen
		}
	}
	sort.Slice(tiles, func(i, j int) bool {
		return tiles[i][1] < tiles[j][1]
	})
	for i, j, cnt, m := 0, 0, 0, len(tiles); j < m; {
		for ; j < m && tiles[j][1]-tiles[i][0]+1 <= carpetLen; j++ {
			cnt += tiles[j][1] - tiles[j][0] + 1
		}
		if j < m {
			res = max(res, cnt+max(0, carpetLen-(tiles[j][0]-tiles[i][0])))
		} else {
			res = max(res, cnt)
		}
		cnt -= tiles[i][1] - tiles[i][0] + 1
		i++
	}
	return
}
