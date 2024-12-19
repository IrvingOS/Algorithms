package code2555

//func maximizeWin(prizePositions []int, k int) (res int) {
//	n := len(prizePositions)
//	if prizePositions[n-1]-prizePositions[0] <= k {
//		return n
//	}
//	left, mx := 0, make([]int, n+1)
//	for right, pos := range prizePositions {
//		for pos-prizePositions[left] > k {
//			left++
//		}
//		res = max(res, mx[left]+right-left+1)
//		mx[right+1] = max(mx[right], right-left+1)
//	}
//	return
//}

func maximizeWin(prizePositions []int, k int) (res int) {
	left, right, lastMax, n := 0, 0, 0, len(prizePositions)
	for mid, val := range prizePositions {
		for ; val-prizePositions[left] > k; left++ {
		}
		for ; right < n && prizePositions[right]-val <= k; right++ {
		}
		res = max(res, lastMax+right-mid)
		lastMax = max(lastMax, mid-left+1)
	}
	return
}
