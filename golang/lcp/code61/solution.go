package code61

func temperatureTrend(temperatureA []int, temperatureB []int) int {
	res, cur, n := 0, 0, len(temperatureA)
	for i := 1; i < n; i++ {
		if (temperatureA[i] > temperatureA[i-1] && temperatureB[i] > temperatureB[i-1]) ||
			(temperatureA[i] == temperatureA[i-1] && temperatureB[i] == temperatureB[i-1]) ||
			(temperatureA[i] < temperatureA[i-1] && temperatureB[i] < temperatureB[i-1]) {
			cur++
		} else {
			cur = 0
		}
		res = max(res, cur)
	}
	return res
}
