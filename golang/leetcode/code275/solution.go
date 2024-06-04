package code275

func hIndexII(citations []int) int {
	n := len(citations)
	i, j := 0, n-1
	for i <= j {
		mid := i + (j-i)/2
		if citations[mid] >= n-mid {
			j = mid - 1
		} else {
			i = mid + 1
		}
	}
	return n - i
}
