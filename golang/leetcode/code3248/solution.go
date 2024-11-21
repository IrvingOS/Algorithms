package code3248

func finalPositionOfSnake(n int, commands []string) int {
	i, j := 0, 0
	for _, command := range commands {
		switch command {
		case "UP":
			i--
		case "RIGHT":
			j++
		case "DOWN":
			i++
		case "LEFT":
			j--
		}
	}
	return i*n + j
}
