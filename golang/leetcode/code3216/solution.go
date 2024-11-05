package code3216

func getSmallestString(s string) string {
	i := 0
	arr := []rune(s)
	res := make([]rune, len(arr))
	for i < len(arr) && arr[i] == '0' {
		res[i] = '0'
		i++
	}
	for i+1 < len(arr) {
		m := int(arr[i] - '0')
		n := int(arr[i+1] - '0')
		if m > n && m&1 == n&1 {
			res[i] = arr[i+1]
			res[i+1] = arr[i]
			i += 2
			break
		}
		res[i] = arr[i]
		i++
	}
	for i < len(arr) {
		res[i] = arr[i]
		i++
	}
	return string(res)
}
