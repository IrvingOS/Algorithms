package code2734

func smallestString(s string) string {
	n := len(s)
	arr := []byte(s)
	firstIndexOfNotA := 0
	for firstIndexOfNotA < n {
		if arr[firstIndexOfNotA] != 'a' {
			break
		}
		firstIndexOfNotA++
	}
	if firstIndexOfNotA == n {
		arr[n-1] = 'z'
		return string(arr)
	}
	for i := firstIndexOfNotA; i < n; i++ {
		if arr[i] == 'a' {
			break
		}
		arr[i] = arr[i] - 1
	}
	return string(arr)
}
