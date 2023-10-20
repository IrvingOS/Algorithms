package main

import (
	"math"
)

func intToRoman(num int) string {
	dic := map[int]string{
		1:    "I",
		4:    "IV",
		5:    "V",
		9:    "IX",
		10:   "X",
		50:   "L",
		40:   "XL",
		90:   "XC",
		100:  "C",
		400:  "CD",
		500:  "D",
		900:  "CM",
		1000: "M",
	}
	arr := [4]int{}
	i := 3
	for num != 0 {
		pop := num % 10
		arr[i] = pop
		i--
		num /= 10
	}
	if i < 0 {
		i = 0
	}
	result := ""
	for i < 4 {
		cur := arr[i]
		pow := int(math.Pow10(3 - i))
		for cur != 0 {
			v, ok := dic[cur*pow]
			if ok {
				result += v
				cur = 0
			} else {
				k := cur - 1
				for k != 0 {
					v, ok = dic[k*pow]
					if ok {
						result += v
						cur -= k
						break
					}
					k--
				}
			}
		}
		i++
	}
	return result
}

func main() {
	intToRoman(3)
	intToRoman(58)
	intToRoman(1994)
}
