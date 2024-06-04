package code8

import (
	"math"
	"strings"
)

func myAtoi(s string) int {
	s = strings.Trim(s, " ")
	n := len(s)
	negative, digit := false, false
	more, less := false, false
	val := 0
	for i := 0; i < n; i++ {
		if (s[i] == '+' || s[i] == '-') && !digit {
			if s[i] == '-' {
				negative = true
			}
			digit = true
		} else if s[i] >= '0' && s[i] <= '9' {
			digit = true
			val = val*10 + int(s[i]-'0')
			if negative {
				if val*-1 < math.MinInt32 {
					less = true
					break
				}
			} else {
				if val > math.MaxInt32 {
					more = true
					break
				}
			}
		} else {
			break
		}
	}
	if negative {
		if less {
			return math.MinInt32
		}
		return val * -1
	} else {
		if more {
			return math.MaxInt32
		}
		return val
	}
}
