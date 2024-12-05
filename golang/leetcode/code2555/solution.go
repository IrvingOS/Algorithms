package code2555

func maximizeWin(prizePositions []int, k int) (res int) {
	n := len(prizePositions)
	if prizePositions[n-1]-prizePositions[0] <= k {
		return n
	}
	left, mx := 0, make([]int, n+1)
	for right, pos := range prizePositions {
		for pos-prizePositions[left] > k {
			left++
		}
		res = max(res, mx[left]+right-left+1)
		mx[right+1] = max(mx[right], right-left+1)
	}
	return
}

//func maximizeWin(prizePositions []int, k int) int {
//	n := len(prizePositions)
//	if prizePositions[n-1]-prizePositions[0] <= k {
//		return n
//	}
//	left, right, res, leftMax := 0, 0, 0, 0
//	for mid, pos := range prizePositions {
//		for ; right < n && prizePositions[right]-pos <= k; right++ {
//		}
//		res = max(res, leftMax+right-mid)
//		for ; pos-prizePositions[left] > k; left++ {
//		}
//		leftMax = max(leftMax, mid-left+1)
//	}
//	return res
//}
