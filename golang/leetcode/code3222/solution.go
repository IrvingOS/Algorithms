package code3222

func losingPlayer(x int, y int) string {
	for i := 1; ; i++ {
		if x < 1 || y < 4 {
			if i%2 == 1 {
				return "Bob"
			}
			return "Alice"
		}
		x -= 1
		y -= 4
	}
}
