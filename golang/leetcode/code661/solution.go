package code661

func imageSmoother(img [][]int) [][]int {
	m := len(img)
	n := len(img[0])
	res := make([][]int, m)
	for i := 0; i < m; i++ {
		res[i] = make([]int, n)
	}
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			sum := img[i][j]
			c := 1
			if i-1 >= 0 {
				sum += img[i-1][j]
				c++
			}
			if j-1 >= 0 {
				sum += img[i][j-1]
				c++
			}
			if i+1 < m {
				sum += img[i+1][j]
				c++
			}
			if j+1 < n {
				sum += img[i][j+1]
				c++
			}
			if i-1 >= 0 && j-1 >= 0 {
				sum += img[i-1][j-1]
				c++
			}
			if i-1 >= 0 && j+1 < n {
				sum += img[i-1][j+1]
				c++
			}
			if i+1 < m && j-1 >= 0 {
				sum += img[i+1][j-1]
				c++
			}
			if i+1 < m && j+1 < n {
				sum += img[i+1][j+1]
				c++
			}
			res[i][j] = sum / c
		}
	}
	return res
}
