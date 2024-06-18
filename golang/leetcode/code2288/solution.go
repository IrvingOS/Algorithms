package code2288

import (
	"fmt"
	"strconv"
	"strings"
)

func discountPrices(sentence string, discount int) string {
	words := strings.Split(sentence, " ")
	for i := range words {
		if words[i][0] == '$' {
			value := words[i][1:]
			num, err := strconv.ParseInt(value, 10, 64)
			if err != nil {
				continue
			}
			words[i] = fmt.Sprintf("$%.2f", float64(num)*(1-float64(discount)*0.01))
		}
	}
	return strings.Join(words, " ")
}
