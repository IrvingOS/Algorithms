package code11

func maxArea11(height []int) int {
	n := len(height)
	i, j := 0, n-1
	result := 0
	for i < j {
		cur := min(height[i], height[j])
		result = max(result, (j-i)*cur)
		if height[i] < height[j] {
			i++
		} else {
			j--
		}
	}
	return result
}
