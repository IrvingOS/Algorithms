package code9

func isPalindrome(x int) bool {
	if x < 0 {
		return false
	}
	arr := make([]int, 31)
	n := 0
	for x != 0 {
		arr[n] = x % 10
		x = x / 10
		n++
	}
	i, j := 0, n-1
	for i < j {
		if arr[i] != arr[j] {
			return false
		}
		i++
		j--
	}
	return true
}
